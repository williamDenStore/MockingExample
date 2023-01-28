package com.example;

public class Game {
    int rollScore;
    int bonus;
    int lastRoll;
    public void roll(int i) {
        if (bonus>0) {
            rollScore += i;
            if (bonus>2) {
                rollScore += i;
                bonus--;
            }
            bonus--;
        }
        if (i == 10)
            bonus+=2;
        if (i+lastRoll == 10 && i!=10)
            bonus+=1;
        lastRoll=i;
        rollScore+=i;
    }

    public int score() {
        return rollScore;
    }

    public boolean gameIsOver() {
        return false;
    }
}
