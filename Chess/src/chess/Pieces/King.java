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
public class King extends Piece {
    
    public King(PieceTeam pt)
    {
        super(pt);
    }
    
    @Override
    protected  MoveResult isMoveValid(int rowMovement, int colMovement, boolean canCapture)
    {

        boolean res = (Math.abs(rowMovement) <= 1 && Math.abs(colMovement) <= 1 );
        return res ? MoveResult.ValidMove : MoveResult.PieceCannotPerformMove;
    }
       
    @Override
    public String toString()
    {
        return getTeam() == PieceTeam.White ? "K": "k" ;
    }
    
}
