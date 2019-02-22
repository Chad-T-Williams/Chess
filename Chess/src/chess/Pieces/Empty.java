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
public class Empty extends Piece {

    public Empty() {
        super(TeamEnum.NoTeam, false);
    }

    @Override
    protected MoveResultEnum isMoveValid(Point move, boolean canCapture) {
        return MoveResultEnum.SpaceIsEmpty;
    }

    @Override
    public String toString() {
        return "-";
    }
}
