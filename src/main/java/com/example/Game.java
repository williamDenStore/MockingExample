package com.example;

public class Game {
    int rollScore;
    int bonus;
    int lastRoll;
    double frames;
    public void roll(int i) {
        if (bonus>0) {
            rollScore += i;
            if (bonus>2) {
                rollScore += i;
                bonus--;
            }
            bonus--;
        }
        if (i == 10) {
            bonus += 2;
            frames+=0.5;
        }
        if (i+lastRoll == 10 && i!=10)
            bonus+=1;
        lastRoll=i;
        rollScore+=i;
        frames+=0.5;
    }

    public int score() {
        return rollScore;
    }

    public boolean gameIsOver() {
        if (frames>=10)
            return true;
        return false;
    }
}
