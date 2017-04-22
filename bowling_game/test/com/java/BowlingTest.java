package com.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vinaym on 18/10/16.
 */
public class BowlingTest {
    Bowling game;

    @Before
    public void setupBowlingAlley() {
        game = new Bowling();
    }

    @Test
    public void allStrike() {
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertEquals(300,game.totalScore());
    }

    @Test
    public void randomMatchOne() {
        game.roll(1);
        game.roll(4);
        game.roll(4);
        game.roll(5);
        game.roll(6);
        game.roll(4);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(0);
        game.roll(1);
        game.roll(7);
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(10);
        game.roll(2);
        game.roll(8);
        game.roll(6);

        assertEquals(133,game.totalScore());
    }

    @Test
    public void allSpares() {
        game.roll(5);
        game.roll(5);
        game.roll(0);
        game.roll(10);
        game.roll(4);
        game.roll(6);
        game.roll(5);
        game.roll(5);
        game.roll(2);
        game.roll(8);
        game.roll(7);
        game.roll(3);
        game.roll(9);
        game.roll(1);
        game.roll(5);
        game.roll(5);
        game.roll(0);
        game.roll(10);
        game.roll(1);
        game.roll(9);
        game.roll(3);

        assertEquals(136,game.totalScore());
    }
}
