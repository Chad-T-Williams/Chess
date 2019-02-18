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
public class Queen extends Piece {

    public Queen(TeamEnum pt) {
        super(pt, true);
    }

    @Override
    public String toString() {
        return getTeam() == TeamEnum.White ? "Q" : "q";
    }

    @Override
    protected MoveResultEnum isMoveValid(int rowMovement, int colMovement, boolean canCapture) {
        colMovement = Math.abs(colMovement);
        rowMovement = Math.abs(rowMovement);
        boolean res = false;
        if ((colMovement == rowMovement)
                || (colMovement == 0 && rowMovement != 0)
                || (colMovement != 0 && rowMovement == 0)) {
            res = true;
        }
        return res ? MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;
    }

}
