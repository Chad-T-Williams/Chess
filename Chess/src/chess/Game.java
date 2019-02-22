/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.Pieces.MoveResultEnum;
import chess.Pieces.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author chadw
 */
public class Game {

    private final int boardSize = 8;
    private final Piece[][] board = new Piece[boardSize][boardSize];
    private Stack<Action> actionsPerformed = new Stack<Action>();

    private TeamEnum currentPlayer = TeamEnum.White;
    private boolean gameOver = false;

    public Game() {
        startGame();
    }

    public boolean getGameStatus() {
        return gameOver;
    }

    private void initialiseBoard(){
        for (int i = 0; i < boardSize; i++) {
            if (i == 0) {
                board[i] = setUpSpecialRow(TeamEnum.Black);
            } else if (i == 7) {
                board[i] = setUpSpecialRow(TeamEnum.White);
            } else {
                for (int j = 0; j < boardSize; j++) {
                    switch (i) {
                        case 1:
                            board[i][j] = new Pawn(TeamEnum.Black);
                            break;
                        case 6:
                            board[i][j] = new Pawn(TeamEnum.White);
                            break;
                        default:
                            board[i][j] = new Empty();
                            break;
                    }
                }
            }
        }
    }

    public boolean undoAction()
    {
        boolean res = false;
        if (actionsPerformed.isEmpty())
        {
            Action act = actionsPerformed.pop();
            // Set Piece currently at the "End" to the Start of the Action;
            Point startP = act.startPos;
            Point endP = act.endPos;
            board[startP.y][startP.x] = board[endP.y][endP.x];
            board[endP.y][endP.x] = act.pieceTaken;
            currentPlayer = (currentPlayer == TeamEnum.White ? TeamEnum.Black : TeamEnum.White);
            res = true;
        }
        return res;
    }

    public TeamEnum getCurrentPlayer() {
        return currentPlayer;
    }
    public MoveResultEnum performMove(String s) throws IllegalArgumentException
    {
        Point[] coords = StringParser.getCoordinates(s);
        return performMove(coords);
    }
    
    public MoveResultEnum performMove(Point[] moveCoords) {
        if (gameOver) {
            return MoveResultEnum.GameOver;
        }
        Point startP = moveCoords[0];
        Point endP = moveCoords[1];
        Point moveP = new Point(endP.x - startP.x, endP.y - startP.y);
        Piece startPiece = board[startP.y][startP.x];
        Piece targetPiece = board[endP.y][endP.x];
        
        if (startPiece.getCollision()) {
            boolean willCollide = checkCollisionOccurence(startP, moveP);
            if (willCollide) {
                return MoveResultEnum.AttemptedToSkipOverPiece;
            }
        }
        MoveResultEnum res = startPiece.findMoveResult(moveP, targetPiece.getTeam());
        if (res != MoveResultEnum.ValidMove) {
            return res;
        } else if (startPiece.getTeam() != currentPlayer) {
            return MoveResultEnum.MovedEnemyPiece;
        } else {
            board[startP.y][startP.x] = new Empty();
            board[endP.y][endP.x] = startPiece;
            if (targetPiece instanceof chess.Pieces.King) {
                gameOver = true;
                res = MoveResultEnum.GameOver;
            } else {
                currentPlayer = (currentPlayer == TeamEnum.White ? TeamEnum.Black : TeamEnum.White);

                Action act = new Action(targetPiece,startP,endP);
                actionsPerformed.push(act);
            }
        }
        return res;
    }

    private boolean checkCollisionOccurence(Point startPoint, Point movePoint) {
        // Effectively checks from furthest position and goes inwards.
        int moveX = movePoint.x;
        int moveY = movePoint.y;  
        while (true) {
            if (moveX > 0) {
                moveX--;
            } else if (moveX < 0) {
                moveX++;
            }
            if (moveY > 0) {
                moveY--;
            } else if (moveY < 0) {
                moveY++;
            }
            if (moveY == 0 && moveX == 0) {
                // Don't check start Piece
                break;
            }            
            Piece currPiece = board[startPoint.y + moveY][startPoint.x + moveX];
            if (!(currPiece instanceof chess.Pieces.Empty)) {
                // If the piece we're looking at isn't empty it means we tried to skip over a piece.
                return true;
            }
        }
        return false;
    }

    public void startGame() {
        initialiseBoard();
        currentPlayer = TeamEnum.White;
        gameOver = false;
    }

    private Piece[] setUpSpecialRow(TeamEnum pt) {
        Piece[] row = new Piece[boardSize];
        row[0] = new Rook(pt);
        row[7] = new Rook(pt);
        row[1] = new Knight(pt);
        row[6] = new Knight(pt);
        row[2] = new Bishop(pt);
        row[5] = new Bishop(pt);
        if (pt == TeamEnum.White) {
            row[3] = new Queen(pt);
            row[4] = new King(pt);
        } else {
            row[3] = new King(pt);
            row[4] = new Queen(pt);
        }
        return row;
    }

    @Override
    public String toString() {
        String s = "";
        s += generateBoardString();
        s += "The current player is: " + currentPlayer + "\n";
        return s;
    }

    private String generateBoardString() {
        String s = "  ";
        String displayChars = "abcdefgh";
        for (int row = 0; row < boardSize; row++) {
            s += displayChars.charAt(row);
        }
        s += "\n";
        for (int col = 0; col < boardSize; col++) {
            s += 8 - col; // As Board Place goes from 8(top) to 1 (bottom);
            s += " ";
            for (int row = 0; row < boardSize; row++) {
                s += board[col][row];
            }
            s += "\n";
        }
        return s;
    }
}
