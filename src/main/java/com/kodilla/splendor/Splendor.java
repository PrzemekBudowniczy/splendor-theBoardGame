package com.kodilla.splendor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Splendor extends Application {

    private Image imageBack = new Image("file:src/main/resources/general/background_dark.png");

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
        OtherGraphics otherGraphics = new OtherGraphics();

        ImageView blackResL = new ImageView(otherGraphics.getResourcesPics().get(0));
        ImageView blueResL = new ImageView(otherGraphics.getResourcesPics().get(1));
        ImageView goldResL = new ImageView(otherGraphics.getResourcesPics().get(2));
        ImageView greenResL = new ImageView(otherGraphics.getResourcesPics().get(3));
        ImageView redResL = new ImageView(otherGraphics.getResourcesPics().get(4));
        ImageView whiteResL = new ImageView(otherGraphics.getResourcesPics().get(5));
        ImageView blackResR = new ImageView(otherGraphics.getResourcesPics().get(0));
        ImageView blueResR = new ImageView(otherGraphics.getResourcesPics().get(1));
        ImageView goldResR = new ImageView(otherGraphics.getResourcesPics().get(2));
        ImageView greenResR = new ImageView(otherGraphics.getResourcesPics().get(3));
        ImageView redResR = new ImageView(otherGraphics.getResourcesPics().get(4));
        ImageView whiteResR = new ImageView(otherGraphics.getResourcesPics().get(5));

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

        flowPane.getChildren().add(reverse1);
        flowPane.getChildren().add(set1slot1);
        flowPane.getChildren().add(set1slot2);
        flowPane.getChildren().add(set1slot3);

        flowPane.getChildren().add(reverse2);
        flowPane.getChildren().add(set2slot1);
        flowPane.getChildren().add(set2slot2);
        flowPane.getChildren().add(set2slot3);

        flowPane.getChildren().add(reverse3);
        flowPane.getChildren().add(set3slot1);
        flowPane.getChildren().add(set3slot2);
        flowPane.getChildren().add(set3slot3);

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane centralCardDeck = new GridPane();
        centralCardDeck.setAlignment(Pos.CENTER);
        centralCardDeck.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        centralCardDeck.setHgap(5);
        centralCardDeck.setVgap(5);
        centralCardDeck.add(reverse1, 0, 0, 1, 1);
        centralCardDeck.add(set1slot1, 1, 0, 1, 1);
        centralCardDeck.add(set1slot2, 2, 0, 1, 1);
        centralCardDeck.add(set1slot3, 3, 0, 1, 1);

        centralCardDeck.add(reverse2, 0, 1, 1, 1);
        centralCardDeck.add(set2slot1, 1, 1, 1, 1);
        centralCardDeck.add(set2slot2, 2, 1, 1, 1);
        centralCardDeck.add(set2slot3, 3, 1, 1, 1);

        centralCardDeck.add(reverse3, 0, 2, 1, 1);
        centralCardDeck.add(set3slot1, 1, 2, 1, 1);
        centralCardDeck.add(set3slot2, 2, 2, 1, 1);
        centralCardDeck.add(set3slot3, 3, 2, 1, 1);

        GridPane leftSideResources = new GridPane();
        leftSideResources.setHgap(20);
        leftSideResources.setVgap(1);
        leftSideResources.setAlignment(Pos.CENTER);
        leftSideResources.add(blackResL, 1,1,1,1);
        leftSideResources.add(blueResL, 1,2,1,1);
        leftSideResources.add(greenResL, 1,3,1,1);
        leftSideResources.add(redResL, 1,4,1,1);
        leftSideResources.add(whiteResL, 1,5,1,1);
        leftSideResources.add(goldResL, 1,6,1,1);

        Text textLeftSideLabel1Column = new Text("cost\nreduction");
        textLeftSideLabel1Column.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textLeftSideLabel1Column.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideLabel2Column = new Text("resource\ntype");
        textLeftSideLabel2Column.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textLeftSideLabel2Column.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideLabel3Column = new Text("resources\nowned");
        textLeftSideLabel3Column.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textLeftSideLabel3Column.setTextAlignment(TextAlignment.CENTER);

        Text textLeftSideBlackCostReduction = new Text("0");
        textLeftSideBlackCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideBlackCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideBlueCostReduction = new Text("0");
        textLeftSideBlueCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideBlueCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideGreenCostReduction = new Text("0");
        textLeftSideGreenCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideGreenCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideRedCostReduction = new Text("0");
        textLeftSideRedCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideRedCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideWhiteCostReduction = new Text("0");
        textLeftSideWhiteCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideWhiteCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideGoldCostReduction = new Text("0");
        textLeftSideGoldCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideGoldCostReduction.setTextAlignment(TextAlignment.CENTER);

        Text textLeftSideBlackResOwned = new Text("0");
        textLeftSideBlackResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideBlackResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideBlueResOwned = new Text("0");
        textLeftSideBlueResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideBlueResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideGreenResOwned = new Text("0");
        textLeftSideGreenResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideGreenResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideRedResOwned = new Text("0");
        textLeftSideRedResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideRedResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideWhiteResOwned = new Text("0");
        textLeftSideWhiteResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideWhiteResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textLeftSideGoldResOwned = new Text("0");
        textLeftSideGoldResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textLeftSideGoldResOwned.setTextAlignment(TextAlignment.CENTER);

        leftSideResources.add(textLeftSideLabel1Column, 0, 0, 1, 1);
        leftSideResources.add(textLeftSideLabel2Column, 1, 0, 1, 1);
        leftSideResources.add(textLeftSideLabel3Column, 2, 0, 1, 1);

        leftSideResources.add(textLeftSideBlackCostReduction, 0, 1, 1, 1);
        leftSideResources.add(textLeftSideBlueCostReduction, 0, 2, 1, 1);
        leftSideResources.add(textLeftSideGreenCostReduction, 0, 3, 1, 1);
        leftSideResources.add(textLeftSideRedCostReduction, 0, 4, 1, 1);
        leftSideResources.add(textLeftSideWhiteCostReduction, 0, 5, 1, 1);
        leftSideResources.add(textLeftSideGoldCostReduction, 0, 6, 1, 1);

        leftSideResources.add(textLeftSideBlackResOwned, 2, 1, 1, 1);
        leftSideResources.add(textLeftSideBlueResOwned, 2, 2, 1, 1);
        leftSideResources.add(textLeftSideGreenResOwned, 2, 3, 1, 1);
        leftSideResources.add(textLeftSideRedResOwned, 2, 4, 1, 1);
        leftSideResources.add(textLeftSideWhiteResOwned, 2, 5, 1, 1);
        leftSideResources.add(textLeftSideGoldResOwned, 2, 6, 1, 1);

        Text textHumanScore = new Text("Your score: 0");
        textHumanScore.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        textHumanScore.setUnderline(true);

        String cssLayout = "-fx-boarder-color: black;\n" +
                "-fx-border-insets: 100;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: solid;\n";

        VBox leftSideFullDeck = new VBox(textHumanScore, leftSideResources);
        leftSideFullDeck.setAlignment(Pos.CENTER);
        leftSideFullDeck.setSpacing(30);
        leftSideFullDeck.setMinSize(600, 700);
        leftSideFullDeck.setStyle(cssLayout);

        GridPane rightSideResources = new GridPane();
        rightSideResources.setHgap(20);
        rightSideResources.setVgap(1);
        rightSideResources.setAlignment(Pos.CENTER);
        rightSideResources.add(blackResR, 1,1,1,1);
        rightSideResources.add(blueResR, 1,2,1,1);
        rightSideResources.add(greenResR, 1,3,1,1);
        rightSideResources.add(redResR, 1,4,1,1);
        rightSideResources.add(whiteResR, 1,5,1,1);
        rightSideResources.add(goldResR, 1,6,1,1);
        Text textRightSideLabel1Column = new Text("cost\nreduction");
        textRightSideLabel1Column.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textRightSideLabel1Column.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideLabel2Column = new Text("resource\ntype");
        textRightSideLabel2Column.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textRightSideLabel2Column.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideLabel3Column = new Text("resources\nowned");
        textRightSideLabel3Column.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textRightSideLabel3Column.setTextAlignment(TextAlignment.CENTER);

        Text textRightSideBlackCostReduction = new Text("0");
        textRightSideBlackCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideBlackCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideBlueCostReduction = new Text("0");
        textRightSideBlueCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideBlueCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideGreenCostReduction = new Text("0");
        textRightSideGreenCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideGreenCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideRedCostReduction = new Text("0");
        textRightSideRedCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideRedCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideWhiteCostReduction = new Text("0");
        textRightSideWhiteCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideWhiteCostReduction.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideGoldCostReduction = new Text("0");
        textRightSideGoldCostReduction.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideGoldCostReduction.setTextAlignment(TextAlignment.CENTER);

        Text textRightSideBlackResOwned = new Text("0");
        textRightSideBlackResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideBlackResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideBlueResOwned = new Text("0");
        textRightSideBlueResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideBlueResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideGreenResOwned = new Text("0");
        textRightSideGreenResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideGreenResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideRedResOwned = new Text("0");
        textRightSideRedResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideRedResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideWhiteResOwned = new Text("0");
        textRightSideWhiteResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideWhiteResOwned.setTextAlignment(TextAlignment.CENTER);
        Text textRightSideGoldResOwned = new Text("0");
        textRightSideGoldResOwned.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textRightSideGoldResOwned.setTextAlignment(TextAlignment.CENTER);

        rightSideResources.add(textRightSideLabel1Column, 0, 0, 1, 1);
        rightSideResources.add(textRightSideLabel2Column, 1, 0, 1, 1);
        rightSideResources.add(textRightSideLabel3Column, 2, 0, 1, 1);

        rightSideResources.add(textRightSideBlackCostReduction, 0, 1, 1, 1);
        rightSideResources.add(textRightSideBlueCostReduction, 0, 2, 1, 1);
        rightSideResources.add(textRightSideGreenCostReduction, 0, 3, 1, 1);
        rightSideResources.add(textRightSideRedCostReduction, 0, 4, 1, 1);
        rightSideResources.add(textRightSideWhiteCostReduction, 0, 5, 1, 1);
        rightSideResources.add(textRightSideGoldCostReduction, 0, 6, 1, 1);

        rightSideResources.add(textRightSideBlackResOwned, 2, 1, 1, 1);
        rightSideResources.add(textRightSideBlueResOwned, 2, 2, 1, 1);
        rightSideResources.add(textRightSideGreenResOwned, 2, 3, 1, 1);
        rightSideResources.add(textRightSideRedResOwned, 2, 4, 1, 1);
        rightSideResources.add(textRightSideWhiteResOwned, 2, 5, 1, 1);
        rightSideResources.add(textRightSideGoldResOwned, 2, 6, 1, 1);

        Text textComputerScore = new Text("Computer score: 0");
        textComputerScore.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        textComputerScore.setUnderline(true);

        VBox rightSideFullDeck = new VBox(textComputerScore, rightSideResources);
        rightSideFullDeck.setAlignment(Pos.CENTER);
        rightSideFullDeck.setSpacing(30);
        rightSideFullDeck.setMinSize(600, 700);
        rightSideFullDeck.setStyle(cssLayout);

        HBox fullDeck = new HBox(leftSideFullDeck, centralCardDeck, rightSideFullDeck);
        fullDeck.setBackground(background);
        fullDeck.setAlignment(Pos.CENTER);

        Scene scene = new Scene(fullDeck, 1728, 972, Color.BLACK);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
