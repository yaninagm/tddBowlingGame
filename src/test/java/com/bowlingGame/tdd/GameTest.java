package com.bowlingGame.tdd;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void CanMakeGame(){
        new Game();
    }

    @Test
    public void canRollBall(){
        Game game = new Game();
        game.roll(0);
    }

    @Test
    void canScoreGutterGame() {
        Game game = new Game();
        assert game.score() == 0;
    }

    @Test
    void canScoreGame() {
        Game game = new Game();
        for (int score = 0; score < 20; score++) {
            game.roll(1);
        }
        assert game.score() == 20;

    }
}
