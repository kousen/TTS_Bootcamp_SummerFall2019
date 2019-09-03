package com.tts.craps;

import java.util.Arrays;
import java.util.List;

public class GameV1 {

    private int roll() {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int sum = die1 + die2;
        System.out.printf("Shooter rolls %d and %d = %d%n", die1, die2, sum);
        return sum;
    }

    public GameEnum playGame() {
        List<Integer> wins = Arrays.asList(7, 11);
        List<Integer> loses = Arrays.asList(2, 3, 12);
        int point = roll();
        if (wins.contains(point)) {
            return GameEnum.WON;
        } else if (loses.contains(point)) {
            return GameEnum.LOST;
        } else {
            System.out.println("Point is " + point);
            int newRoll;
            while (true) {
                newRoll = roll();
                if (newRoll == point) {
                    return GameEnum.WON;
                } else if (newRoll == 7) {
                    return GameEnum.LOST;
                }
            }
        }
    }
}
