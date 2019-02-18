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
public class Bishop extends Piece {

    public Bishop(TeamEnum pt) {
        super(pt, true);
    }

    @Override
    protected MoveResultEnum isMoveValid(int rowMovement, int colMovement, boolean canCapture) {
        return Math.abs(colMovement) == Math.abs(rowMovement)
                ? MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;

    }

    @Override
    public String toString() {
        return getTeam() == TeamEnum.White ? "B" : "b";
    }

}
