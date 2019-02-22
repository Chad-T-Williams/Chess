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
        MoveResultEnum res = gme.performMove("A2-A3");
        assertEquals( MoveResultEnum.ValidMove, res);
    }

    @Test
    public void checkPawnDoubleMove() {
        MoveResultEnum res = gme.performMove("A2-A4");
        assertEquals(MoveResultEnum.ValidMove,res);
    }

    @Test
    public void checkNoDiagonalMove() {
        MoveResultEnum res = gme.performMove("A2-B3");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);
    }

    @Test
    public void checkPawnOnlyDoubleMoveOnce() {
        gme.performMove("A2-A4");
        gme.performMove("B7-B6");
        MoveResultEnum res = gme.performMove("A4-A6");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);
    }

    @Test
    public void testPawnDiagonalCapture() {
        gme.performMove("A2-A4");
        gme.performMove("B7-B5");
        MoveResultEnum res = gme.performMove("A4-B5");
        assertEquals( MoveResultEnum.ValidMove,res);
    }

    @Test
    public void testPawnStraightCapture() {
        gme.performMove("A2-A4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("A4-A5");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);
    }
    @Test
    public void testBishopValidMovement()
    {
        gme.performMove("B2-B4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("C1-A3");
        assertEquals(MoveResultEnum.ValidMove,res);        
    }   
    @Test
    public void testBishopInvalidMovement()
    {
        gme.performMove("C2-C4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("C1-C3");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);  
    }
    @Test
    public void testKingMovementValid()
    {
        gme.performMove("D2-D4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("E1-D2");
        assertEquals(MoveResultEnum.ValidMove,res);
    }
    @Test
    public void testKingInvalidMovement()
    {
        gme.performMove("E2-E4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("E1-E3");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);
    }
    @Test
    public void testQueenValidMovement()
    {
        gme.performMove("E2-E4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("D1-H5");
        assertEquals(MoveResultEnum.ValidMove,res);   
    }
    @Test
    public void testQueenInvalidMovement()
    {
        gme.performMove("D2-D4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("D1-E3");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);   
        
    }
    @Test
    public void testRookValidMovement()
    {
        gme.performMove("A2-A4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("A1-A3");
        assertEquals(MoveResultEnum.ValidMove,res);   
    }
    @Test
    public void testRookInvalidMovement()
    {
        gme.performMove("B2-B4");
        gme.performMove("A7-A5");
        MoveResultEnum res = gme.performMove("A1-B2");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);        
    }
    @Test
    public void testKnightValidMovement()
    {
        MoveResultEnum res = gme.performMove("B1-A3");
        assertEquals(MoveResultEnum.ValidMove,res);
    }
    @Test
    public void testKnightInValidMovement()
    {
        MoveResultEnum res = gme.performMove("B1-B3");
        assertEquals(MoveResultEnum.PieceCannotPerformMove,res);
    }
                        
    @Test
    public void testCantCaptureOwnPiece()
    {
        MoveResultEnum res = gme.performMove("A1-A2");
        assertEquals(MoveResultEnum.TakenOwnPiece,res);
    }
    @Test
    public void testCantSkipOwnPiece()
    {
        MoveResultEnum res = gme.performMove("A1-A3");
        assertEquals(MoveResultEnum.AttemptedToSkipOverPiece,res);
    }
           
}
