package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



}
