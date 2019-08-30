package com.tts.craps;

public class TwoDice {
    private int dice1;
    private int dice2;

    public TwoDice(int dice1, int dice2) {
        this.dice1 = dice1;
        this.dice2 = dice2;
    }

    public int roll() {
        dice1 = getDiceValue();
        dice2 = getDiceValue();
        return dice1 + dice2;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    private int getDiceValue() {
        return (int) (Math.random() * 6) + 1;
    }
}
