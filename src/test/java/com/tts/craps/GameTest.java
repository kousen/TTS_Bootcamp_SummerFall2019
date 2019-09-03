package com.tts.craps;

import org.junit.Test;

public class GameTest {
    private GameV1 game = new GameV1();

    @Test
    public void runGame() {
        GameEnum result = game.playGame();
        if (result == GameEnum.WON) {
            System.out.println("You won!");
        } else if (result == GameEnum.LOST) {
            System.out.println("You lost.");
        }
    }
}