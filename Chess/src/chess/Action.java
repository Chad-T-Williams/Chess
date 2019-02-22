package chess;
import chess.Pieces.*;
import java.awt.*;

public class Action {

    public final Piece pieceTaken;
    public final Point startPos;
    public final Point endPos;

    public Action(Piece pT, Point sP, Point eP)
    {
        pieceTaken = pT;
        startPos = sP;
        endPos = eP;
    }
}
