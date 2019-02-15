/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import chess.Pieces.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author chadw
 */
public class Game { 
    final int boardSize = 8;
    private Piece[][] board = new Piece[boardSize][boardSize];
    private static Scanner myIn = new Scanner(System.in);

    public Game()
    {
        initialiseBoard();
    }
    public void run()
    {
        int choice = 100;
        while (choice != 0)
        {
            System.out.println("Enter the number of your choice");
            System.out.println("\t 1.Print out the current Board");
            System.out.println("\t 2. ReinitialiseBoard");
            if (choice == 1)
            {
                printBoard();
            }
            else if (choice == 2)
            {
                initialiseBoard();
            }
            choice =  myIn.nextInt();
        }
    }
    private void initialiseBoard()
    {
        for(int i =0; i < boardSize; i++)
        {
            if (i == 0)
            {
                board[i] = setUpSpecialRow(PieceTeam.Black);
            }
            else if (i== 7)
            {
                board[i] = setUpSpecialRow(PieceTeam.White);
            }
            else
            {
                for(int j = 0; j < boardSize; j++)
                {
                    switch (i) {
                        case 1:
                            board[i][j] = new Pawn(PieceTeam.Black);
                            break;
                        case 6:
                            board[i][j] = new Pawn(PieceTeam.White);
                            break;
                        default:
                            board[i][j] = new Empty();
                            break;
                    }
                }
            }
        }
    }
    private Piece[] setUpSpecialRow(PieceTeam pt)
    {
        // Unsure of a better soltuion
        Piece[] row = new Piece[boardSize];
        row[0] = new Rook(pt);
        row[7] = new Rook(pt);
        row[1] = new Knight(pt);
        row[6] = new Knight(pt);
        row[2] = new Bishop(pt);
        row[5] = new Bishop(pt);
        if (pt == PieceTeam.White)
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

    private void printBoard()
    {
        System.out.println(generateBoardString());
    }
    
    private String generateBoardString()
    {
        String s = " ";
        for (int i = 0; i < boardSize; i++)
        {
            s += i;
        }
        s += "\n";
        for (int j = 0; j < boardSize; j++)
        {
            s += j;
            for(int k = 0; k < boardSize; k++)
            {
                s += board[j][k];
            }
            s += "\n";
        }
        return s;
    }
}
