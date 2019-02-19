package chess;
import chess.Pieces.*;

public class Action {

    public final Piece pieceTaken;
    public final int[] startPos;
    public final int[] endPos;

    public Action(Piece pT, int[] sP, int[] eP)
    {
        pieceTaken = pT;
        startPos = sP;
        endPos = eP;
    }
}
