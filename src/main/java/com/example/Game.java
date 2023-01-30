package com.example;

public class Game {
    private int totalScore;
    private int bonus;
    private int lastRoll;
    private double frames;
    public void roll(int rollScore) {
        if (!gameIsOver()) {
            if (bonus > 0)
                applyBonus(rollScore);
            addBonus(rollScore);
            updateVariables(rollScore);
            if(frames>=10.5)
                totalScore -=rollScore;
        }
    }

    private void updateVariables(int i) {
        lastRoll = i;
        totalScore += i;
        frames += 0.5;
    }

    private void addBonus(int i) {
        if (strike(i)) {
            bonus += 2;
            frames += 0.5;
        }
        if (spare(i))
            bonus += 1;
    }

    private boolean strike(int i) {
        return i == 10 && frames < 10;
    }

    private boolean spare(int i) {
        return i + lastRoll == 10 && i != 10;
    }

    private void applyBonus(int i) {
        totalScore += i;
        if (bonus > 2) {
            totalScore += i;
            bonus--;
        }
        bonus--;
    }

    public int score() {
        return totalScore;
    }

    public boolean gameIsOver() {
        if (frames>=10 && bonus == 0)
            return true;
        return false;
    }
}
