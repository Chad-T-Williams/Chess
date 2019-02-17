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
public class King extends Piece {
    
    public King(TeamEnum pt)
    {
        super(pt, true);
    }
    
    @Override
    protected  MoveResultEnum isMoveValid(int colMovement, int rowMovement, boolean canCapture)
    {

        boolean res = (Math.abs(rowMovement) <= 1 && Math.abs(colMovement) <= 1 );
        return res ? MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;
    }
       
    @Override
    public String toString()
    {
        return getTeam() == TeamEnum.White ? "K": "k" ;
    }
    
}
