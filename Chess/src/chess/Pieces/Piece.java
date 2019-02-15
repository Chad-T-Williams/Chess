/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Pieces;
import chess.MoveResult;

/**
 *
 * @author chadw
 */
public abstract class Piece {
    private final PieceTeam team;
    
    public Piece(PieceTeam tm)
    {
        team = tm;
    }
    
    public PieceTeam getTeam()
    {
        return team;
    }
    
    protected abstract MoveResult isMoveValid(int rowMovement, int colMovement, boolean canCapture);
       
    public MoveResult findMoveResult(int rowMovement, int colMovement, PieceTeam targetTeam)
    {
        
        if (rowMovement == 0 && colMovement == 0){
            return MoveResult.NoMoveAttempted;
        }
        else if (targetTeam == getTeam())
        {
            return MoveResult.TakenOwnPiece;
        }
        boolean canCapture = (targetTeam !=  PieceTeam.NoTeam);
        return isMoveValid(rowMovement, colMovement, canCapture);
        
    }
}
