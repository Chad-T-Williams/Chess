/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.Pieces.MoveResultEnum;
import chess.Pieces.*;

/**
 *
 * @author chadw
 */
public class Game {

    private final int boardSize = 8;
    private final Piece[][] board = new Piece[boardSize][boardSize];
    private TeamEnum currentPlayer = TeamEnum.White;
    private boolean gameOver = false;

    public Game() {
        startGame();
    }

    public boolean getGameStatus() {
        return gameOver;
    }

    private void initialiseBoard() {
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

    public TeamEnum getCurrentPlayer() {
        return currentPlayer;
    }

    public MoveResultEnum performMove(int[] moveCoords) {
        if (gameOver) {
            return MoveResultEnum.GameOver;
        }
        int startCol = moveCoords[0];
        int startRow = moveCoords[1];
        int endCol = moveCoords[2];
        int endRow = moveCoords[3];

        int moveRow = endRow - startRow;
        int moveCol = endCol - startCol;

        Piece startPiece = board[startRow][startCol];
        Piece targetPiece = board[endRow][endCol];
        if (startPiece.getCollision()) {
            boolean willCollide = checkCollisionOccurence(startRow, startCol, moveRow, moveCol);
            if (willCollide) {
                return MoveResultEnum.AttemptedToSkipOverPiece;
            }
        }
        MoveResultEnum res = startPiece.findMoveResult(moveRow, moveCol, targetPiece.getTeam());

        if (res != MoveResultEnum.ValidMove) {
            return res;
        } else if (startPiece.getTeam() != currentPlayer) {
            return MoveResultEnum.MovedEnemyPiece;
        } else {
            board[startRow][startCol] = new Empty();
            board[endRow][endCol] = startPiece;
            if (targetPiece instanceof chess.Pieces.King) {
                gameOver = true;
                res = MoveResultEnum.GameOver;
            } else {
                currentPlayer = (currentPlayer == TeamEnum.White ? TeamEnum.Black : TeamEnum.White);
            }
        }
        return res;
    }

    private boolean checkCollisionOccurence(int startY, int startX, int moveY, int moveX) {
        // Effectively checks from furthest position and goes inwards.
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
            Piece currPiece = board[startY + moveY][startX + moveX];
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
