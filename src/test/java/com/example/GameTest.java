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
}
