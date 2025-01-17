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
    @Test
    void gameIsOverShouldReturnTrueAfter20rollsWithNoStrike(){
        Game game = new Game();

        for (int i = 0; i < 20; i++) {
            game.roll(4);
        }

        assertTrue(game.gameIsOver());
    }
    @Test
    void gameIsOverShouldBeTrueAfter9StrikesThen5And3(){
        Game game = new Game();

        for (int i = 0; i < 9; i++) {
            game.roll(10);
        }
        game.roll(5);
        game.roll(3);

        assertTrue(game.gameIsOver());
    }
    @Test
    void gameIsOverShouldBeFalseIfLastRollIsStrike(){
        Game game = new Game();

        for (int i = 0; i < 10; i++) {
            game.roll(10);
        }

        assertFalse(game.gameIsOver());
    }
    @Test
    void gameIsOverShouldBeFalseIfLastRollIsSpare(){
        Game game = new Game();

        for (int i = 0; i < 9; i++) {
            game.roll(10);
        }
        game.roll(5);
        game.roll(5);

        assertFalse(game.gameIsOver());
    }
    @Test
    void rollingWhenGameIsOverDoesNotAddAnyScore(){
        Game game = new Game();

        for (int i = 0; i < 9; i++) {
            game.roll(10);
        }
        game.roll(3);
        game.roll(5);
        game.roll(5);

        assertEquals(259, game.score());

    }
    @Test
    void rolling10StrikesThen5And4ShouldReturn284(){
        Game game = new Game();

        for (int i = 0; i < 10; i++) {
            game.roll(10);
        }
        game.roll(5);
        game.roll(4);

        assertEquals(284, game.score());
    }
    @Test
    void rolling15StrikesShouldStopAfter12AndReturnScoreOf300(){
        Game game = new Game();

        for (int i = 0; i < 15; i++) {
            game.roll(10);
        }

        assertEquals(300, game.score());
    }
    @Test
    void rolling9StrikeThen9And1Then3ShouldReturn272(){
        Game game = new Game();

        for (int i = 0; i < 9; i++) {
            game.roll(10);
        }
        game.roll(9);
        game.roll(1);
        game.roll(3);

        assertEquals(272, game.score());
    }
    @Test
    void rollingStrikeAndSpareEveryOther(){
        Game game = new Game();

        for (int i = 0; i < 15; i++) {
            if (i%2==0){
                game.roll(10);
            }
            else {
                game.roll(5);
                game.roll(5);
            }
        }
        assertEquals(200, game.score());
    }
}
