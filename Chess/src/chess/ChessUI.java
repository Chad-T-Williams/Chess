/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.*;

/**
 *
 * @author chadw
 */
public class ChessUI {

    /**
     * @param args the command line arguments
     */
    private static Game game;
    private static Scanner myIn = new Scanner(System.in);

    public static void main(String[] args) {
        game = new Game();
        runGame();

        // TODO code application logic here
    }

    public static void runGame() {
        String choice = " ";
        while (!choice.equals("0")) {
            System.out.println("Enter the number of your choice");
            System.out.println("\t9. To restart the game!");
            System.out.println("\t0. To end the game!");
            System.out.println("Or: To move a piece enter the starting and ending coordinates seperated by a hyphen. Like: A2-A4");
            System.out.println("White's Pieces are represented by capital letters");
            System.out.println();
            System.out.println(game);
            choice = myIn.next();
            try {
                if (choice.equals("9")) 
                {
                    game.startGame();
                } 
                else if (!choice.equals("0")) {
                    int[] coords = StringParser.getCoordinates(choice);
                    MoveResultEnum res = game.performMove(coords);
                    if (null != res) {
                        switch (res) {
                            case ValidMove:
                                System.out.println("The Move was Performed");
                                break;
                            case MovedEnemyPiece:
                                System.out.println("You attempted to move an enemy piece.");
                                break;
                            case NoMoveAttempted:
                                System.out.println("You did not attempt to move a piece.");
                                break;
                            case PieceCannotPerformMove:
                                System.out.println("The movement attempted cannot be performed by the selected Piece.");
                                break;
                            case SpaceIsEmpty:
                                System.out.println("You attempted to move a space with no pieces on it.");
                                break;
                            case TakenOwnPiece:
                                System.out.println("You attempted to take your own piece. This is illegal.");
                                break;
                            case AttemptedToSkipOverPiece:
                                System.out.println("You attempted to skip over a piece.");
                                break;
                            case GameOver:
                                System.out.println("The game is over! The winner was: " + game.getCurrentPlayer());
                                break;
                            default:
                                break;
                        }
                    }

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("You need to choose a number.");
            }
            System.out.println();
            System.out.println();
            System.out.println();

                        
        }
        System.out.println("Thank you for playing this game!");
    }

}
