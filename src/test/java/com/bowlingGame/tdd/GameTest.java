package com.bowlingGame.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    //No es buena practica compartir instancias entre test, por eso usamos un setup
    //Game game = new Game();

    Game game;
    @BeforeEach
    void setUp() {
        Game game = new Game();
    }

    @Test
    void canScoreGutterGame() {
        assert game.score() == 0;
    }

    @Test
    void canScoreGame() {
        for (int score = 0; score < 20; score++) {
            game.roll(1);
        }
        assert game.score() == 20;

    }
}
