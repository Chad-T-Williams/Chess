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
    
    protected abstract MoveResultEnum isMoveValid(int colMovement ,int rowMovement, boolean canCapture);
       
    public MoveResultEnum findMoveResult(int colMovement,int rowMovement, TeamEnum targetTeam)
    {
        
        if (rowMovement == 0 && colMovement == 0) {
            return MoveResultEnum.NoMoveAttempted;
        } else if (targetTeam == getTeam()) {
            return MoveResultEnum.TakenOwnPiece;
        }
        boolean canCapture = (targetTeam !=  TeamEnum.NoTeam);
        return isMoveValid(colMovement, rowMovement, canCapture);
        
    }
}
