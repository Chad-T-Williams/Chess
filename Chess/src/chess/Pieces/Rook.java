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
public class Rook extends Piece {
    
    public Rook(PieceTeam pt)
    {
        super(pt);
    }
    
    @Override
    public String toString()
    {
        return getTeam() == PieceTeam.White ? "R": "r" ;
    }
    
    @Override
    protected  MoveResult isMoveValid(int rowMovement, int colMovement, boolean canCapture)
    {
        boolean res = false;
        if ((rowMovement == 0 && colMovement != 0) || 
                (rowMovement != 0 && colMovement == 0)){
            res = true;
        }        
        return res ? MoveResult.ValidMove : MoveResult.PieceCannotPerformMove;
    }
    
    
}
