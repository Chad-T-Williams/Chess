/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import chess.*;
import chess.Pieces.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author chadw
 */
public class FullGameplayTest {

    public FullGameplayTest() {
    }
    private Game gme;

    @Before
    public void setUp() {
        gme = new Game();
    }

    @Test
    public void testGameOver() {
        int[] whiteMove1 = StringParser.getCoordinates("D2-D4");
        int[] blackMove1 = StringParser.getCoordinates("A7-A5");
        int[] whiteMove2 = StringParser.getCoordinates("D4-D5");
        int[] blackMove2 = StringParser.getCoordinates("A5-A4");
        int[] whiteMove3 = StringParser.getCoordinates("D5-D6");
        int[] blackMove3 = StringParser.getCoordinates("A4-A3");
        int[] whiteMove4 = StringParser.getCoordinates("D6-C7");
        int[] blackMove4 = StringParser.getCoordinates("A3-B2");
        int[] whiteMove5 = StringParser.getCoordinates("C7-D8");
        gme.performMove(whiteMove1);
        gme.performMove(blackMove1);
        gme.performMove(whiteMove2);
        gme.performMove(blackMove2);
        gme.performMove(whiteMove3);
        gme.performMove(blackMove3);
        gme.performMove(whiteMove4);
        gme.performMove(blackMove4);
        MoveResultEnum res = gme.performMove(whiteMove5);
        assertEquals(res, MoveResultEnum.GameOver);
    }
}
