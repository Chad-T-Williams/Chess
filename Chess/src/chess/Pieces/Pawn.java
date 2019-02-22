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
public class Pawn extends Piece {
    
    public Pawn(TeamEnum pt)
    {
        super(pt, true);
    }
    
    @Override
    protected  MoveResultEnum isMoveValid(Point move, boolean canCapture)
    {
        boolean res;       
        TeamEnum tm = getTeam();
        int rowMovement = move.y;
        int colMovement = move.x; 
        if (tm == TeamEnum.White && rowMovement >= 0)
        {
            res = false;
        }
        else if(tm == TeamEnum.Black && rowMovement <= 0 )
        {
            res = false;
        }
        else if (canCapture == false)
        {
             if (colMovement != 0)
             {
                 res = false;
             }
             else {
                int maxMovement = getTimesMoved() == 0 ? 2 : 1;
                res = Math.abs(rowMovement) <= maxMovement;
             }        
        }
        else 
        {
            res = (Math.abs(rowMovement) == 1 && Math.abs(colMovement) == 1);
        }
        return res ? MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;
    }    
    
    @Override
    public String toString()
    {
        return getTeam() == TeamEnum.White ? "P": "p" ;
    }    
}
