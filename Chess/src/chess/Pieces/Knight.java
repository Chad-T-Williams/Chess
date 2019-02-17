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
public class Knight extends Piece {
 
    public Knight(TeamEnum pt)
    {
        super(pt, false);
    }  
    
    @Override
    protected  MoveResultEnum isMoveValid(int colMovement,int rowMovement, boolean canCapture)
    {
        int rabs = Math.abs(rowMovement);
        int cabs = Math.abs(colMovement);
        int highValue = rabs > cabs ? rabs : cabs;
        int lowValue = rabs < cabs ? rabs : cabs;
        boolean res = (highValue == 2 && lowValue == 1); 
        // Knights can only move in L-Shapes.    
        return res ? MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;
    }    
    
    @Override
    public String toString()
    {
        return getTeam() == TeamEnum.White ? "N": "n" ;
    }    
    
}
