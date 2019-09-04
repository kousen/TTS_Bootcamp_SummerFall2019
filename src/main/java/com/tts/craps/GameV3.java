package com.tts.craps;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameV3 extends Application {
    private ImageView dieImage1;
    private ImageView dieImage2;

    // ArrayList, and Random objects.
    private Random rand;
    private ArrayList<Image> imageList;

    public static void main(String[] args) {
        launch(args);
    }

    private void initialize() {
        rand = new Random();

        // Load the images.
        Image[] images = new Image[]{
                new Image("Dice-1.png"),
                new Image("Dice-2.png"),
                new Image("Dice-3.png"),
                new Image("Dice-4.png"),
                new Image("Dice-5.png"),
                new Image("Dice-6.png")
        };
        imageList = new ArrayList<>(Arrays.asList(images));
    }

    @Override
    public void start(Stage stage) {
        initialize();
        StackPane root = new StackPane();
        root.setPrefSize(300.0, 200.0);
        HBox dice = new HBox();
        dieImage1 = new ImageView();
        dieImage2 = new ImageView();
        dieImage1.setFitWidth(104.0);
        dieImage1.setFitHeight(104.0);
        dieImage2.setFitWidth(104.0);
        dieImage2.setFitHeight(104.0);
        dice.getChildren().addAll(dieImage1, dieImage2);
        dice.setAlignment(Pos.BASELINE_CENTER);
        Button rollButton = new Button("Roll the Dice");
        rollButton.setOnAction(event -> rollButtonListener());
        rollButton.setPadding(new Insets(10));
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.BASELINE_CENTER);
        vbox.getChildren().addAll(dice, rollButton);
        root.getChildren().add(vbox);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setPadding(new Insets(25));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void rollButtonListener() {
        // Set die1 to a random image.
        dieImage1.setImage(imageList.get(rand.nextInt(imageList.size())));

        // Set die2 to a random image.
        dieImage2.setImage(imageList.get(rand.nextInt(imageList.size())));
    }
}
