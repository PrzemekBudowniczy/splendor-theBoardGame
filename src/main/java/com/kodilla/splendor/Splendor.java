package com.kodilla.splendor;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Splendor extends Application {

    private Image imageBack = new Image("file:src/main/resources/general/background_dark.png");

    private FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);

    ImageView reverse1;
    ImageView set1slot1;
    ImageView set1slot2;
    ImageView set1slot3;

    ImageView reverse2;
    ImageView set2slot1;
    ImageView set2slot2;
    ImageView set2slot3;

    ImageView reverse3;
    ImageView set3slot1;
    ImageView set3slot2;
    ImageView set3slot3;

    List<ImageView> allVisibleCardsOnTable = new ArrayList<>();
    List<Rectangle> allVisibleCardsOnTableWrapped = new ArrayList<>();
    List<ImagePattern> allVisibleCardsOnTableImagePatterns = new ArrayList<>();
    PlayerActions playerActions = new PlayerActions();
    List<Text> leftSideResourcesOwned;
    List<Text> rightSideResourcesOwned;
    GridPane leftSideResources;
    Scene scene;
    List<Button> buttonsResources;

    GridPane centralCardDeck;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        CardsGraphics cards = new CardsGraphics();
        CardsOnTheGame cardsOnTheGame = new CardsOnTheGame();
        OtherGraphics otherGraphics = new OtherGraphics();

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        leftSideResourcesOwned = new ArrayList<>();
        rightSideResourcesOwned = new ArrayList<>();

        centralCardDeck = new GridPane();
        centralCardDeck.setAlignment(Pos.CENTER);
        centralCardDeck.setPadding(new Insets(1, 1, 1, 1));
        centralCardDeck.setHgap(5);
        centralCardDeck.setVgap(5);

        RefreshViewOfCardsOnTable(cardsOnTheGame);

        leftSideResources = new GridPane();
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
        List<Text> rightSideCostReduction = new ArrayList<>();


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
        fullDeck.setAlignment(Pos.CENTER);

        Text actions = new Text("Possible actions");
        actions.setFont(Font.font("Arial", FontWeight.BOLD, 15));


        buttonsResources = new ArrayList<>();
        buttonsResources.add(new Button("Black"));
        buttonsResources.add(new Button("Blue"));
        buttonsResources.add(new Button("Green"));
        buttonsResources.add(new Button("Red"));
        buttonsResources.add(new Button("White"));
        buttonsResources.add(new Button("Reset selected"));

        String styleNotPushedButton = "-fx-background-color: #ffffff; ";
        for(Button button : buttonsResources) {
            button.setStyle(styleNotPushedButton);
        }

        for(int i=0; i<5; i++) {
            int finalI = i;
            buttonsResources.get(i).setOnAction(vent -> {
                PushedButtonAddingResource(buttonsResources.get(finalI), finalI +1);
            });
        }
        buttonsResources.get(5).setOnAction(event -> {ResetSelected(buttonsResources);});

        Text labelSelectResources = new Text("Select 3 resources");
        labelSelectResources.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        HBox selectResources = new HBox(10, labelSelectResources, buttonsResources.get(0), buttonsResources.get(1), buttonsResources.get(2), buttonsResources.get(3), buttonsResources.get(4), buttonsResources.get(5));

        Text labelBuyCard = new Text("To buy a card - click button & select a card");
        labelBuyCard.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        Button buttonBuyCard = new Button("Buy card");
        HBox buyCard = new HBox(5, labelBuyCard, buttonBuyCard);

        VBox actionsPanel = new VBox(10, selectResources, buyCard);
        actionsPanel.setAlignment(Pos.CENTER);

        Text textPossibleActions = new Text("Possible actions: ");
        textPossibleActions.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textPossibleActions.setUnderline(true);
        HBox topPanel = new HBox(30, textPossibleActions, actionsPanel);
        topPanel.setAlignment(Pos.CENTER);

        VBox fullTable = new VBox(20, topPanel, fullDeck);
        fullTable.setBackground(background);
        fullTable.setAlignment(Pos.CENTER);

        scene = new Scene(fullTable, 1728, 972, Color.BLACK);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();

//        for(int i=1; i<12; i++) {
//            if(i == 4 || i == 8) {continue;}
//            allVisibleCardsOnTable.get(i).setOnMouseClicked(event -> HighlightCardToBuy(finalI));
//        }
        allVisibleCardsOnTable.get(1).setOnMouseClicked(event -> HighlightCardToBuy(1));
        allVisibleCardsOnTable.get(2).setOnMouseClicked(event -> HighlightCardToBuy(2));
        allVisibleCardsOnTable.get(3).setOnMouseClicked(event -> HighlightCardToBuy(3));
        allVisibleCardsOnTable.get(5).setOnMouseClicked(event -> HighlightCardToBuy(4));
        allVisibleCardsOnTable.get(6).setOnMouseClicked(event -> HighlightCardToBuy(5));
        allVisibleCardsOnTable.get(7).setOnMouseClicked(event -> HighlightCardToBuy(6));
        allVisibleCardsOnTable.get(9).setOnMouseClicked(event -> HighlightCardToBuy(7));
        allVisibleCardsOnTable.get(10).setOnMouseClicked(event -> HighlightCardToBuy(8));
        allVisibleCardsOnTable.get(11).setOnMouseClicked(event -> HighlightCardToBuy(9));
    }

    private void HighlightCardToBuy(int positionInTableCards) {
        System.out.println("clicked " + positionInTableCards);

    }

    private void ButtonStyleResetForResources(List<Button> buttons) {
        String styleNotPushedButton = "-fx-background-color: #ffffff; ";
        for(Button button : buttons) {
            button.setStyle(styleNotPushedButton);
        }
    }

    private void PushedButtonAddingResource(Button theButton, int resourceSelected) {

        String stylePushedButton = "-fx-background-color: #3b3636; -fx-text-fill: #ffffff";
        theButton.setStyle(stylePushedButton);
        boolean isTransactionFinalized = playerActions.AddSelectedResourceAndCheckIfTransactionFinalized(resourceSelected);

        if (isTransactionFinalized == true) {
            ButtonStyleResetForResources(buttonsResources);
            RefreshViewOfOwnedResourcesHuman();
        }
    }

    private void ResetSelected(List<Button> buttons) {
        ButtonStyleResetForResources(buttons);
        playerActions.clearSelectedResources();
    }

    public void RefreshViewOfCardsOnTable(CardsOnTheGame cardsOnTheGame) {

        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getReverseForDeck().get(2)));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(7).getCardGraphic()));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(8).getCardGraphic()));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(9).getCardGraphic()));

        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getReverseForDeck().get(1)));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(4).getCardGraphic()));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(5).getCardGraphic()));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(6).getCardGraphic()));

        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getReverseForDeck().get(0)));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(1).getCardGraphic()));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(2).getCardGraphic()));
        allVisibleCardsOnTable.add(new ImageView(cardsOnTheGame.getCardsOnTable().get(3).getCardGraphic()));

        Rectangle newRectangle = new Rectangle(180, 252);
        newRectangle.setArcHeight(30);
        newRectangle.setArcWidth(30);
        ImagePattern pattern = new ImagePattern(cardsOnTheGame.getReverseForDeck().get(2));
        newRectangle.setFill(pattern);

        for(int i=1; i<13; i++) {
            flowPane.getChildren().add(allVisibleCardsOnTable.get(i-1));
            if(i < 5) {
                centralCardDeck.add(allVisibleCardsOnTable.get(i-1), i-1, 0, 1, 1);
            } else if (i < 9) {
                centralCardDeck.add(allVisibleCardsOnTable.get(i-1), i-5, 1, 1, 1);
            } else {
                centralCardDeck.add(allVisibleCardsOnTable.get(i-1), i-9, 2, 1, 1);
            }
        }
    }

    public void RefreshViewOfOwnedResourcesHuman() {
        List<Integer> freshViewOfOwnedResources = playerActions.getPlayerResourcesOwned(true);
        for(int i=0; i<6; i++) {
            String theValue = freshViewOfOwnedResources.get(i).toString();
            leftSideResourcesOwned.get(i).setText(theValue);
        }
    }

    public void RefreshViewOfOwnedResourcesComputer() {
        List<Integer> freshViewOfOwnedResources = playerActions.getPlayerResourcesOwned(false);
        for(int i=0; i<6; i++) {
            String theValue = freshViewOfOwnedResources.get(i).toString();
            rightSideResourcesOwned.get(i).setText(theValue);
        }
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
