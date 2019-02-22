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
public class Knight extends Piece {

    public Knight(TeamEnum pt) {
        super(pt, false);
    }

    @Override
    protected MoveResultEnum isMoveValid(Point move, boolean canCapture) {
        int cabs = Math.abs(move.x);
        int rabs = Math.abs(move.y);
        int highValue = cabs > rabs ? cabs : rabs;
        int lowValue = cabs < rabs ? cabs : rabs;
        boolean res = (highValue == 2 && lowValue == 1);
        // Knights can only move in L-Shapes.    
        return res ? MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;
    }

    @Override
    public String toString() {
        return getTeam() == TeamEnum.White ? "N" : "n";
    }

}
