/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author chadw
 */
public enum MoveResultEnum {
    ValidMove("Move is Valid"), 
    SpaceIsEmpty("Space is Empty"), 
    TakenOwnPiece("Attempted to Taken Own Piece"),
    PieceCannotPerformMove("Piece Cannot Perform Move"),
    MovedEnemyPiece("Attempted to Move Enemy Piece"),
    NoMoveAttempted("No Move Attempted"),
    AttemptedToSkipOverPiece("Attempted to Skip over a Piece"),
    GameOver("The Game is Over");

    
    private String moveResult;
    
    private MoveResultEnum(String res)
    {
        moveResult = res;
    }
    
    public String toString()
    {
        return moveResult;
    }
}
