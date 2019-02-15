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
public enum MoveResult {
    ValidMove("Move is Valid"), 
    SpaceIsEmpty("Space is Empty"), 
    TakenOwnPiece("Attempted to Taken Own Piece"),
    PieceCannotPerformMove("Piece Cannot Perform Move"),
    MovedEnemyPiece("Attempted to Move Enemy Piece"),
    MovedOffBoard("Attempted to Move Off Board"),
    NoMoveAttempted("No Move Attempted");
    
    
    private String moveResult;
    
    private MoveResult(String res)
    {
        moveResult = res;
    }
    
    public String toString()
    {
        return moveResult;
    }
}
