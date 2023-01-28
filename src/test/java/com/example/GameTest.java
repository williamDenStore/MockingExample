package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    void rollingZeroTwiceInOneGameShouldReturnZero(){
        Game game = new Game();

        game.roll(0);
        game.roll(0);

        assertEquals(0,game.score());
    }
    @Test
    void rollingDownOnePinTwiceInOneFrameShouldReturnTwo(){
        Game game = new Game();

        game.roll(1);
        game.roll(1);

        assertEquals(2,game.score());
    }
    @Test
    void rolling1And2Then6And3ShouldReturnScoreOf12(){
        Game game = new Game();

        game.roll(1);
        game.roll(2);
        game.roll(6);
        game.roll(3);
        assertEquals(12, game.score());
    }
    @Test
    void rollingStrikeThen4And3ShouldReturn24(){
        Game game = new Game();
        game.roll(10);
        game.roll(4);
        game.roll(3);

        assertEquals(24,game.score());
    }
    @Test
    void rollingStrikeThen4And5ShouldReturn28(){
        Game game = new Game();
        game.roll(10);
        game.roll(4);
        game.roll(5);

        assertEquals(28,game.score());
    }
    @Test
    void rolling6And4Then5And3ShouldReturn23(){
        Game game = new Game();
        game.roll(6);
        game.roll(4);
        game.roll(5);
        game.roll(3);

        assertEquals(23, game.score());
    }
    @Test
    void rolling6And4Then7And2ShouldReturn26(){
        Game game = new Game();
        game.roll(6);
        game.roll(4);
        game.roll(7);
        game.roll(2);

        assertEquals(26, game.score());
    }
    @Test
    void rollingStrikeThen7And3Then4And5ShouldReturn43(){
        Game game = new Game();
        game.roll(10);
        game.roll(7);
        game.roll(3);
        game.roll(4);
        game.roll(5);

        assertEquals(43, game.score());
    }
    @Test
    void rollingStrikeTwiceThen4And2ShouldReturn46(){
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(4);
        game.roll(2);

        assertEquals(46,game.score());
    }
    @Test
    void rollingStrikeTwiceThen4And2Then3And3ShouldReturn52(){
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(4);
        game.roll(2);
        game.roll(3);
        game.roll(3);

        assertEquals(52,game.score());
    }
    @Test
    void gameIsOverShouldReturnFalseIfNoRollsHasBeenMade(){
        Game game = new Game();

        assertFalse(game.gameIsOver());
    }




}
