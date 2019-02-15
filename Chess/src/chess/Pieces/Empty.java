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
public class Empty extends Piece {
    
    public Empty()
    {
        super(PieceTeam.NoTeam);
    }
    
    @Override
    protected  MoveResult isMoveValid(int rowMovement, int colMovement, boolean canCapture)
    {       
        return MoveResult.SpaceIsEmpty;
    }
               
    @Override
    public String toString()
    {
        return "-";
    }
}
