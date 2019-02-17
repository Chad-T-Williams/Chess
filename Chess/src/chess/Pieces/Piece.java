/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Pieces;
import chess.MoveResultEnum;

/**
 *
 * @author chadw
 */
public abstract class Piece {
    private final TeamEnum team;
    private boolean canHopOver;
    
    public Piece(TeamEnum tm, boolean canSkip)
    {
        team = tm;
        canHopOver = canSkip;
    }
    
    public boolean getHop()
    {
        return canHopOver;
    }
    public TeamEnum getTeam()
    {
        return team;
    }
    
    protected abstract MoveResultEnum isMoveValid(int rowMovement, int colMovement, boolean canCapture);
       
    public MoveResultEnum findMoveResult(int rowMovement, int colMovement, TeamEnum targetTeam)
    {
        
        if (rowMovement == 0 && colMovement == 0){
            return MoveResultEnum.NoMoveAttempted;
        }
        else if (targetTeam == getTeam())
        {
            return MoveResultEnum.TakenOwnPiece;
        }
        boolean canCapture = (targetTeam !=  TeamEnum.NoTeam);
        return isMoveValid(rowMovement, colMovement, canCapture);
        
    }
}
