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
public class Pawn extends Piece {
    
    private boolean hasMoved = false;
    public Pawn(TeamEnum pt)
    {
        super(pt, true);
    }
    
    @Override
    protected  MoveResultEnum isMoveValid(int rowMovement, int colMovement, boolean canCapture)
    {
        boolean res;       
        TeamEnum tm = getTeam();
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
             else{
                int maxMovement = hasMoved ? 1: 2;
                res = Math.abs(rowMovement) <= maxMovement;
             }        
        }
        else 
        {
            res = (Math.abs(rowMovement) == 1 && Math.abs(colMovement) == 1);
        }          
        if (res)
        {
            hasMoved = true;
            return MoveResultEnum.ValidMove;
        }
        else
        {
            return MoveResultEnum.PieceCannotPerformMove;
        }
    }    
    
    @Override
    public String toString()
    {
        return getTeam() == TeamEnum.White ? "P": "p" ;
    }    
}
