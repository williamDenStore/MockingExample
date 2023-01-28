package com.example;

public class Game {
    int rollScore;
    int bonus;
    public void roll(int i) {
        if (i == 10)
            rollScore+=7;
        rollScore+=i;
    }

    public int score() {
        return rollScore;
    }
}
