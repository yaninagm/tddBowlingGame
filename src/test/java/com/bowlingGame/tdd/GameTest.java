package com.bowlingGame.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameTest {
    //No es buena practica compartir instancias entre test, por eso usamos un setup
    //Game game = new Game();

    private Game game;
    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    private void roll(int pinsDown, int time) {
        for (int i = 0; i < time; i++) {
            game.roll(pinsDown);
        }
    }

    @Test
    void canScoreGutterGame() {
        game.score();
        roll(0, 20);
        assert game.score() == 0;
    }

    @Test
    void canScoreGameOfOnes() {
        roll(1, 20);
        assert game.score() == 20;
    }

    @Test
    public void canScoreGameUniqueSpare(){
        game.roll(5);
        game.roll(5);
        roll(0,7);

        assert game.score() == 10;
    }

    @Test
    public void canScoreGameSpareAndOther(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        roll(0,7);

        assert game.score() == 16;
    }

}
