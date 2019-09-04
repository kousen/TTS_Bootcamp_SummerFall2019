package com.tts.craps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GameV4 extends JFrame {
    private GameEnum gameStatus = GameEnum.FIRST_ROLL;
    private int point;

    private String imageDir = "src/main/resources/";

    // Images from https://commons.wikimedia.org/wiki/Category:Dice_faces
    private String[] diceImageFiles = {"Dice-1.png", "Dice-2.png",
            "Dice-3.png", "Dice-4.png", "Dice-5.png", "Dice-6.png"};

    private ImageIcon[] diceImageIcons;

    private JLabel firstDie;
    private JLabel secondDie;
    private JLabel statusLabel;
    private JTextArea history = new JTextArea("Results go here");
    private JButton startButton = new JButton("Start New Game");
    private JButton rollButton = new JButton("Roll Dice");

    public GameV4() {
        super("Craps Game V2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel north = new JPanel();
        JPanel west = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        loadDiceImages();

        history.setEditable(false);
        history.setWrapStyleWord(true);
        history.setFont(new Font("Dialog", Font.PLAIN, 16));
        history.setSize(100, 200);
        JScrollPane scrollPane = new JScrollPane(history);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        west.add(scrollPane);

        firstDie = new JLabel(diceImageIcons[0]);
        secondDie = new JLabel(diceImageIcons[0]);
        center.add(firstDie);
        center.add(secondDie);

        startButton.addActionListener(this::startGame);
        rollButton.addActionListener(this::rollDice);
        rollButton.setEnabled(false);
        south.add(startButton);
        south.add(rollButton);

        statusLabel = new JLabel("Click start button to play");
        north.add(statusLabel);

        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);

        setLocationRelativeTo(null);
        setSize(600, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameV4::new);
    }

    private void loadDiceImages() {
        diceImageIcons = Stream.of(diceImageFiles)
                .map(fileName -> new ImageIcon(imageDir + fileName))
                .toArray(ImageIcon[]::new);
    }

    private void startGame(ActionEvent e) {
        gameStatus = GameEnum.FIRST_ROLL;
        statusLabel.setText("Starting new game. Click roll button");
        history.setText("New game.");
        rollButton.setEnabled(true);
    }

    public void setGameStatus(int roll) {
        List<Integer> wins = Arrays.asList(7, 11);
        List<Integer> loses = Arrays.asList(2, 3, 12);
        GameEnum newStatus = GameEnum.PLAYING;
        if (gameStatus == GameEnum.FIRST_ROLL) {
            point = roll;
            statusLabel.setText("Point is " + point);
            rollButton.setEnabled(true);
            if (wins.contains(point)) {
                newStatus = GameEnum.WON;
            } else if (loses.contains(point)) {
                newStatus = GameEnum.LOST;
            } else {
                newStatus = GameEnum.PLAYING;
            }
        } else if (gameStatus == GameEnum.PLAYING) {
            if (roll == point) {
                newStatus = GameEnum.WON;
            } else if (roll == 7) {
                newStatus = GameEnum.LOST;
            }
        }
        gameStatus = newStatus;
    }

    public void rollDice(ActionEvent e) {
        int sum = roll();
        setGameStatus(sum);
        if (gameStatus == GameEnum.WON) {
            statusLabel.setText("You won!");
            rollButton.setEnabled(false);
        } else if (gameStatus == GameEnum.LOST) {
            statusLabel.setText("You lost. Try again.");
            rollButton.setEnabled(false);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private int roll() {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int sum = die1 + die2;
        history.append("\nShooter rolls " + sum);
        firstDie.setIcon(diceImageIcons[die1 - 1]);
        secondDie.setIcon(diceImageIcons[die2 - 1]);
        return sum;
    }
}
