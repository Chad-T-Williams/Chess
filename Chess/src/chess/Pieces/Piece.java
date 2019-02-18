/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Pieces;

/**
 *
 * @author chadw
 */
public abstract class Piece {
    private final TeamEnum team;
    private boolean hasCollision;
    
    public Piece(TeamEnum tm, boolean canSkip)
    {
        team = tm;
        hasCollision = canSkip;
    }
    
    public boolean getCollision()
    {
        return hasCollision;
    }
    public TeamEnum getTeam()
    {
        return team;
    }
    
    protected abstract MoveResultEnum isMoveValid(int rowMovement ,int colMovement, boolean canCapture);
       
    public MoveResultEnum findMoveResult(int rowMovement,int colMovement, TeamEnum targetTeam)
    {
        
        if (colMovement == 0 && rowMovement == 0) {
            return MoveResultEnum.NoMoveAttempted;
        } else if (targetTeam == getTeam()) {
            return MoveResultEnum.TakenOwnPiece;
        }
        boolean canCapture = (targetTeam !=  TeamEnum.NoTeam);
        return isMoveValid(rowMovement, colMovement, canCapture);
        
    }
}
