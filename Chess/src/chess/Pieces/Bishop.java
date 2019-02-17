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
public class Bishop extends Piece
{
    public Bishop(TeamEnum pt)
    {
        super(pt, false);
    }
    
    @Override
    protected  MoveResultEnum isMoveValid(int rowMovement, int colMovement, boolean canCapture)
    {       
        return Math.abs(rowMovement) == Math.abs(colMovement) ? 
                MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;

    }
       
    @Override
    public String toString()
    {
        return getTeam() == TeamEnum.White ? "B": "b" ;
    }
    
}
