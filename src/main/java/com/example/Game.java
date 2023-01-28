package com.example;

public class Game {
    int rollScore;
    int bonus;
    public void roll(int i) {
        if (bonus>0)
            rollScore+=i;
        if (i == 10)
            bonus=2;
        rollScore+=i;
    }

    public int score() {
        return rollScore;
    }
}
