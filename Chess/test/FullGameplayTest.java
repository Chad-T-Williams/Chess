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
        gme.performMove("D2-D4");
        gme.performMove("A7-A5");
        gme.performMove("D4-D5");
        gme.performMove("A5-A4");
        gme.performMove("D5-D6");
        gme.performMove("A4-A3");
        gme.performMove("D6-C7");
        gme.performMove("A3-B2");
        MoveResultEnum res = gme.performMove("C7-D8");
        assertEquals(MoveResultEnum.GameOver,res);
    }
}
