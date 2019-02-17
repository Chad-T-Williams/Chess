/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import chess.*;
import chess.Pieces.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chadw
 */
public class PieceMovementTest {

    public PieceMovementTest() {
    }
    public Game gme;

    @Before
    public void setUp() {
        gme = new Game();
    }

    @Test
    public void checkPawnMoveForward() {
        int[] pwnMove = StringParser.getCoordinates("A2-A3");
        MoveResultEnum res = gme.performMove(pwnMove);
        assertEquals(res, MoveResultEnum.ValidMove);
    }

    @Test
    public void checkPawnDoubleMove() {
        int[] pwnMove = StringParser.getCoordinates("A2-A4");
        MoveResultEnum res = gme.performMove(pwnMove);
        assertEquals(res, MoveResultEnum.ValidMove);
    }

    @Test
    public void checkNoDiagonalMove() {
        int[] pwnMove = StringParser.getCoordinates("A2-B3");
        MoveResultEnum res = gme.performMove(pwnMove);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);
    }

    @Test
    public void checkPawnOnlyDoubleMoveOnce() {
        int[] whiteMove1 = StringParser.getCoordinates("A2-A4");
        int[] blackMove1 = StringParser.getCoordinates("B7-B6");
        int[] whiteMove2 = StringParser.getCoordinates("A4-A6");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);
    }

    @Test
    public void testPawnDiagonalCapture() {
        int[] whiteMove1 = StringParser.getCoordinates("A2-A4");
        int[] blackMove1 = StringParser.getCoordinates("B7-B5");
        int[] whiteMove2 = StringParser.getCoordinates("A4-B5");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.ValidMove);
    }

    @Test
    public void testPawnStraightCapture() {
        int[] whiteMove1 = StringParser.getCoordinates("A2-A4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("A4-A5");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);
    }
    @Test
    public void testBishopValidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("B2-B4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("C1-A3");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.ValidMove);        
    }   
    @Test
    public void testBishopInvalidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("C2-C4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("C1-C3");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);  
    }
    @Test
    public void testKingMovementValid()
    {
        int[] whiteMove1 = StringParser.getCoordinates("D2-D4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("E1-D2");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.ValidMove);
    }
    @Test
    public void testKingInvalidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("E2-E4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("E1-E3");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);
    }
    @Test
    public void testQueenValidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("E2-E4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("D1-H5");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.ValidMove);   
    }
    @Test
    public void testQueenInvalidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("D2-D4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("D1-E3");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);   
        
    }
    @Test
    public void testRookValidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("A2-A4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("A1-A3");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.ValidMove);   
    }
    @Test
    public void testRookInvalidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("B2-B4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("A1-B2");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        MoveResultEnum res = gme.performMove(whiteMove2);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);        
    }
    @Test
    public void testKnightValidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("B1-A3");
        MoveResultEnum res = gme.performMove(whiteMove1);
        assertEquals(res, MoveResultEnum.ValidMove);
    }
    @Test
    public void testKnightInValidMovement()
    {
        int[] whiteMove1 = StringParser.getCoordinates("B1-B3");
        MoveResultEnum res = gme.performMove(whiteMove1);
        assertEquals(res, MoveResultEnum.PieceCannotPerformMove);
    }
                        
    @Test
    public void testCantCaptureOwnPiece()
    {
        int[] whiteMove1 = StringParser.getCoordinates("A1-A2");
        MoveResultEnum res = gme.performMove(whiteMove1);
        assertEquals(res, MoveResultEnum.TakenOwnPiece);
    }
    @Test
    public void testCantSkipOwnPiece()
    {
        int[] whiteMove1 = StringParser.getCoordinates("A1-A3");
        MoveResultEnum res = gme.performMove(whiteMove1);
        assertEquals(res, MoveResultEnum.AttemptedToSkipOverPiece);
    }
            

}
