package com.bowlingGame.tdd;

public class Game {
    private int score;
    public void roll(int pinsDown) {
        score = score + pinsDown;
    }

    public int score() {
        return score;
    }
}
