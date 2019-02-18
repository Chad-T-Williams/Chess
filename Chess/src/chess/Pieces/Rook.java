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
public class Rook extends Piece {

    public Rook(TeamEnum pt) {
        super(pt, true);
    }

    @Override
    public String toString() {
        return getTeam() == TeamEnum.White ? "R" : "r";
    }

    @Override
    protected MoveResultEnum isMoveValid(int rowMovement, int colMovement, boolean canCapture) {
        boolean res = false;
        if ((colMovement == 0 && rowMovement != 0)
                || (colMovement != 0 && rowMovement == 0)) {
            res = true;
        }
        return res ? MoveResultEnum.ValidMove : MoveResultEnum.PieceCannotPerformMove;
    }

}
