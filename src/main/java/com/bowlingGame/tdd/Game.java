package com.bowlingGame.tdd;

import java.util.ArrayList;
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
        int result = calculateFrames();
        int score = 0 ;
        for (int i = 0; i < frames.size() ; i++) {
            score += frames.get(i);
        }
        return score;
    }

    private int calculateFrames() {
        int total = 0;
        for (int frameId = 0; frameId < 11 ; frameId ++) {
            frame = calculateFrame(frameId);
            frames.add(frame);
        }
        return total;
    }

    private int calculateFrame(int frameId) {
        int celd = frameId * 2;
        if (celd > 19){
            return rolls[celd];
        }
        if (rolls[celd] + rolls[celd+1] == 10 ){
            frame = 10 + calculateFrame((celd+2)/2);
        }else {
            frame = rolls[celd] + rolls[celd+1];
        }

        return frame;
    }
}
