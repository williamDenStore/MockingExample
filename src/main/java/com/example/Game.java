package com.example;

public class Game {
    int rollScore;
    public void roll(int i) {
        rollScore+=i;
    }

    public int score() {
        return rollScore;
    }
}
