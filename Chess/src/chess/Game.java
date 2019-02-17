/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
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

    public Game()
    {
        startGame();
    }
    private void initialiseBoard()
    {
        for(int i =0; i < boardSize; i++)
        {
            if (i == 0)
            {
                board[i] = setUpSpecialRow(TeamEnum.Black);
            }
            else if (i== 7)
            {
                board[i] = setUpSpecialRow(TeamEnum.White);
            }
            else
            {
                for(int j = 0; j < boardSize; j++)
                {
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
    public TeamEnum getCurrentPlayer()
    {
        return currentPlayer;
    }
    public MoveResultEnum performMove(int[] moveCoords)
    {
        if (gameOver)
        {
            return MoveResultEnum.GameOver;
        }
        int startingX = moveCoords[0];
        int startingY = moveCoords[1];
        int endingX = moveCoords[2];
        int endingY = moveCoords[3];

        System.out.println("SX: " + startingX);
        System.out.println("SY: " + startingY);
        System.out.println("EX: " + endingX);
        System.out.println("EY: " + endingY);
        
        int xMove = endingX - startingX;
        int yMove = endingY - startingY;
        Piece startPiece = board[startingY][startingX];
        Piece targetPiece = board[endingY][endingX];
        MoveResultEnum res = startPiece.findMoveResult(xMove, yMove, targetPiece.getTeam());
        if (res != MoveResultEnum.ValidMove)
        {
            return res;
        }
        else if (startPiece.getTeam() != currentPlayer)
        {
            return MoveResultEnum.MovedEnemyPiece;
        }
        else
        {
            board[startingY][startingX] = new Empty();
            board[endingY][endingX] = startPiece;    
            if (targetPiece instanceof chess.Pieces.King)
            {
                gameOver = true;
                res = MoveResultEnum.GameOver;
            }
            else{
                currentPlayer = (currentPlayer == TeamEnum.White ? TeamEnum.Black: TeamEnum.White); 
            }
        }
        return res;
    }
    public void startGame()
    {
        initialiseBoard();
        currentPlayer = TeamEnum.White;
        gameOver = false;
    }
    private Piece[] setUpSpecialRow(TeamEnum pt)
    {
        Piece[] row = new Piece[boardSize];
        row[0] = new Rook(pt);
        row[7] = new Rook(pt);
        row[1] = new Knight(pt);
        row[6] = new Knight(pt);
        row[2] = new Bishop(pt);
        row[5] = new Bishop(pt);
        if (pt == TeamEnum.White)
        {
            row[3] = new Queen(pt);
            row[4] = new King(pt);
        }
        else
        {
            row[3] = new King(pt);
            row[4] = new Queen(pt);
        }
        return row;
    }
    
    @Override
    public String toString()
    {
        String s = "";
        s += generateBoardString();
        s += "The current player is: " + currentPlayer + "\n";
        return s;
    } 
    
    private String generateBoardString()
    {
        String s = "  ";
        String displayChars = "abcdefgh";
        for (int i = 0; i < boardSize; i++)
        {
            s += displayChars.charAt(i);
        }
        s += "\n";
        for (int j = 0; j < boardSize; j++)
        {
            s += 8 - j; // As Board Place goes from 8(top) to 1 (bottom);

            s+= " ";
            for(int k = 0; k < boardSize; k++)
            {
                s += board[j][k];
            }
            s += "\n";
        }
        return s;
    }
}
