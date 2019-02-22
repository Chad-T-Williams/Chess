/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Pieces;
import java.awt.*;

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
    
    protected abstract MoveResultEnum isMoveValid(Point move, boolean canCapture);
       
    public MoveResultEnum findMoveResult(Point move, TeamEnum targetTeam)
    {
        
        if (move.x == 0 && move.y == 0) {
            return MoveResultEnum.NoMoveAttempted;
        } else if (targetTeam == getTeam()) {
            return MoveResultEnum.TakenOwnPiece;
        }
        boolean canCapture = (targetTeam !=  TeamEnum.NoTeam);
        return isMoveValid(move, canCapture);
        
    }
}
