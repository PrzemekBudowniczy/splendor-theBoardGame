package com.kodilla.splendor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Splendor extends Application {

    private Image imageBack = new Image("file:src/main/resources/general/background_dark.png");
    private Image reverse1 = new Image("file:src/main/resources/general/1.reverse.png", 125, 175, false, false);
    private Image reverse2 = new Image("file:src/main/resources/general/2.reverse.png");
    private Image reverse3 = new Image("file:src/main/resources/general/3.reverse.png");

    private FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Group root = new Group();
//        Scene scene = new Scene(root, 300, 300, Color.BLACK);
//
//        Rectangle r = new Rectangle(25, 25, 250, 250);
//        r.setFill(Color.BLUE);
//
//        root.getChildren().add(r);

        Cards cards = new Cards();

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setBackground(background);

        ImageView reverse1 = new ImageView(cards.getReverses().get(0));
        ImageView set1slot1 = new ImageView(cards.getCardsSet1().get(0));
        ImageView set1slot2 = new ImageView(cards.getCardsSet1().get(1));
        ImageView set1slot3 = new ImageView(cards.getCardsSet1().get(2));

        ImageView reverse2 = new ImageView(cards.getReverses().get(1));
        ImageView set2slot1 = new ImageView(cards.getCardsSet2().get(0));
        ImageView set2slot2 = new ImageView(cards.getCardsSet2().get(1));
        ImageView set2slot3 = new ImageView(cards.getCardsSet2().get(2));

        ImageView reverse3 = new ImageView(cards.getReverses().get(2));
        ImageView set3slot1 = new ImageView(cards.getCardsSet3().get(0));
        ImageView set3slot2 = new ImageView(cards.getCardsSet3().get(1));
        ImageView set3slot3 = new ImageView(cards.getCardsSet3().get(2));

        grid.add(reverse1, 0, 0, 1, 1);
        grid.add(set1slot1, 1, 0, 1, 1);
        grid.add(set1slot2, 2, 0, 1, 1);
        grid.add(set1slot3, 3, 0, 1, 1);

        grid.add(reverse2, 0, 1, 1, 1);
        grid.add(set2slot1, 1, 1, 1, 1);
        grid.add(set2slot2, 2, 1, 1, 1);
        grid.add(set2slot3, 3, 1, 1, 1);

        grid.add(reverse3, 0, 2, 1, 1);
        grid.add(set3slot1, 1, 2, 1, 1);
        grid.add(set3slot2, 2, 2, 1, 1);
        grid.add(set3slot3, 3, 2, 1, 1);

        Scene scene = new Scene(grid, 1728, 972, Color.BLACK);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
