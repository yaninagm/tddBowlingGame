package com.bowlingGame.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private int roll = 0;
    private int[] rolls = new int[21];
    private int frame = 0;
    private List<Integer> frames = new ArrayList<>();
    
    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    public int score() {
        /*
        int score = 0 ;
        for (int i = 0; i < rolls.length ; i++) {
            score += rolls[i];

        }
        */


        return calculateFrames(1);
    }

    private int calculateFrames(int i) {
        int total = 0;
        for (int j = 0; j < 11 ; j += 2) {
            frame = calculateFrame(j);
            frames.add(frame);
            total += frame;
        }
        return total;
    }

    private int calculateFrame(int i) {
        if (i > 19){
            return rolls[i];
        }
        if (i %2 == 0 ){
            if (rolls[i] + rolls[i+1] == 10 ){
                frame = 10 + calculateFrame(i+2);
            }else {
                frame = rolls[i];
            }
        }
        return frame;
    }
}
