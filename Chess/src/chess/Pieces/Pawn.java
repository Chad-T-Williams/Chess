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
public class Pawn extends Piece {
    
    private boolean hasMoved = false;
    public Pawn(PieceTeam pt)
    {
        super(pt);
    }
    
    public void SetPawnMoved()
    {
        hasMoved = true;
    }
    
    @Override
    protected  MoveResult isMoveValid(int rowMovement, int colMovement, boolean canCapture)
    {
        boolean res;       
        PieceTeam tm = getTeam();
        if (tm == PieceTeam.White && colMovement >= 0)
        {
            res = false;
        }
        else if(tm == PieceTeam.Black && colMovement <= 0 )
        {
            res = false;
        }
        else if (canCapture == false)
        {
             if (rowMovement != 0)
             {
                 res = false;
             }
             else{
                int maxMovement = hasMoved ? 1: 2;
                res = Math.abs(colMovement) <= maxMovement;
             }        
        }
        else 
        {
            res = (Math.abs(colMovement) == 1 && Math.abs(rowMovement) == 1);
        }                
        return res ? MoveResult.ValidMove : MoveResult.PieceCannotPerformMove;
    }    
    
    @Override
    public String toString()
    {
        return getTeam() == PieceTeam.White ? "P": "p" ;
    }    
}
