package com.tts.craps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GameV2 extends JFrame {

    private String imageDir = "src/main/resources/";

    // Images from https://commons.wikimedia.org/wiki/Category:Dice_faces
    private String[] diceImageFiles = { "Dice-1.png", "Dice-2.png",
        "Dice-3.png", "Dice-4.png", "Dice-5.png", "Dice-6.png" };

    private ImageIcon[] diceImageIcons;

    private JLabel firstDie;
    private JLabel secondDie;
    private JLabel status;
    private JTextArea history = new JTextArea("Results go here");

    public GameV2() {
        super("Craps Game V2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel north = new JPanel();
        JPanel east = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        loadDiceImages();

        history.setEditable(false);
        history.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(history);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        east.add(scrollPane);

        firstDie = new JLabel(diceImageIcons[0]);
        secondDie  = new JLabel(diceImageIcons[0]);
        center.add(firstDie);
        center.add(secondDie);

        JButton rollButton = new JButton("Play Game");
        rollButton.addActionListener(this::startGame);
        south.add(rollButton);

        status = new JLabel("Click button to play");
        north.add(status);

        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);

        setLocationRelativeTo(null);
        setSize(600,300);
        setVisible(true);
    }

    private void loadDiceImages() {
        diceImageIcons = Stream.of(diceImageFiles)
                .map(fileName -> new ImageIcon(imageDir + fileName))
                .toArray(ImageIcon[]::new);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameV2::new);
    }

    private void startGame(ActionEvent e) {
        GameEnum result = playGame();
        if (result == GameEnum.WON) {
            status.setText("You won!");
        } else if (result == GameEnum.LOST) {
            status.setText("You lost. Try again.");
        }
    }

    private int roll() {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int sum = die1 + die2;
        history.append("\nShooter rolls " + sum);
        firstDie.setIcon(diceImageIcons[die1 - 1]);
        secondDie.setIcon(diceImageIcons[die2 - 1]);
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
            history.setText("Point is " + point);
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
