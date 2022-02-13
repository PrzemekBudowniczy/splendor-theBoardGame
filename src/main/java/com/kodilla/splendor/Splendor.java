package com.kodilla.splendor;

import javafx.application.Application;
import javafx.geometry.*;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Splendor extends Application {

    private Image imageBack = new Image("file:src/main/resources/general/background_dark.png");

    private FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Cards cards = new Cards();
        OtherGraphics otherGraphics = new OtherGraphics();

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
        centralCardDeck.setPadding(new Insets(1, 1, 1, 1));
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

        GridPane rightSideResources = new GridPane();
        rightSideResources.setHgap(20);
        rightSideResources.setVgap(1);
        rightSideResources.setAlignment(Pos.CENTER);

        String labelCostReduction = "cost\nreduction";
        String labelResourceType = "resource\ntype";
        String labelResourceOwned = "resources\nowned";

        List<Text> resourcesTableLabels = new ArrayList<>();
        resourcesTableLabels.add(new Text(labelCostReduction));
        resourcesTableLabels.add(new Text(labelResourceType));
        resourcesTableLabels.add(new Text(labelResourceOwned));
        resourcesTableLabels.add(new Text(labelCostReduction));
        resourcesTableLabels.add(new Text(labelResourceType));
        resourcesTableLabels.add(new Text(labelResourceOwned));

        List<Text> leftSideCostReduction = new ArrayList<>();
        List<Text> leftSideResourcesOwned = new ArrayList<>();
        List<Text> rightSideCostReduction = new ArrayList<>();
        List<Text> rightSideResourcesOwned = new ArrayList<>();


        for(int i=0; i<3; i++) {
            TextFormattingSmall(resourcesTableLabels.get(i));
            TextFormattingSmall(resourcesTableLabels.get(i+3));
            leftSideResources.add(resourcesTableLabels.get(i), i, 0, 1, 1);
            rightSideResources.add(resourcesTableLabels.get(i+3), i, 0, 1, 1);
        }

        for(int i=0; i<6; i++) {
            leftSideCostReduction.add(new Text("0"));
            TextFormattingBig(leftSideCostReduction.get(i));
            leftSideResources.add(leftSideCostReduction.get(i), 0, i+1, 1, 1);
            leftSideResources.add(new ImageView(otherGraphics.getResourcesPics().get(i)), 1, i+1, 1, 1);
            leftSideResourcesOwned.add(new Text("0"));
            TextFormattingBig(leftSideResourcesOwned.get(i));
            leftSideResources.add(leftSideResourcesOwned.get(i), 2, i+1, 1, 1);

            rightSideCostReduction.add(new Text("0"));
            TextFormattingBig(rightSideCostReduction.get(i));
            rightSideResources.add(rightSideCostReduction.get(i), 0, i+1, 1, 1);
            rightSideResources.add(new ImageView(otherGraphics.getResourcesPics().get(i)), 1, i+1, 1, 1);
            rightSideResourcesOwned.add(new Text("0"));
            TextFormattingBig(rightSideResourcesOwned.get(i));
            rightSideResources.add(rightSideResourcesOwned.get(i), 2, i+1, 1, 1);
        }


        Text textHumanScore = new Text("Your score: 0");
        textHumanScore.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textHumanScore.setUnderline(true);

        VBox leftSideFullDeck = new VBox(textHumanScore, leftSideResources);
        leftSideFullDeck.setAlignment(Pos.CENTER);
        leftSideFullDeck.setSpacing(30);

        Text textComputerScore = new Text("Computer score: 0");
        textComputerScore.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textComputerScore.setUnderline(true);

        VBox rightSideFullDeck = new VBox(textComputerScore, rightSideResources);
        rightSideFullDeck.setAlignment(Pos.CENTER);
        rightSideFullDeck.setSpacing(30);

        HBox fullDeck = new HBox(70, leftSideFullDeck, centralCardDeck, rightSideFullDeck);
        fullDeck.setMargin(centralCardDeck, new Insets(0, 0, 0, 0));
        fullDeck.setBackground(background);
        fullDeck.setAlignment(Pos.CENTER);

        Scene scene = new Scene(fullDeck, 1728, 972, Color.BLACK);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Text TextFormattingSmall(Text text) {
        text.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        text.setTextAlignment(TextAlignment.CENTER);
        return text;
    }

    public Text TextFormattingBig(Text text) {
        text.setFont(Font.font("Arial", FontWeight.BOLD, 30));
//        text.setTextAlignment(TextAlignment.CENTER);
        return text;
    }
}
