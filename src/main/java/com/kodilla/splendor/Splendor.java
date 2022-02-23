package com.kodilla.splendor;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.InnerShadow;
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
    List<Text> leftSideCostReduction;
    List<Text> rightSideResourcesOwned;
    List<Text> rightSideCostReduction;
    List<Text> topSideResourcesSelected;
    List<Text> textBanksResources;
    GridPane leftSideResources;
    Scene scene;
    List<ImageView> imageViewListResourcesForTopBox;
    ImageView lastSelectedCardToBuy;
    CardsOnTheGame cardsOnTheGame;
    List<Integer> selectedResources;
    Text textHumanScore;
    Text textComputerScore;


    GridPane centralCardDeck;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        CardsGraphics cards = new CardsGraphics();
        cardsOnTheGame = new CardsOnTheGame();
        OtherGraphics otherGraphics = new OtherGraphics();

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        leftSideResourcesOwned = new ArrayList<>();
        leftSideCostReduction = new ArrayList<>();
        rightSideResourcesOwned = new ArrayList<>();
        rightSideCostReduction = new ArrayList<>();
        topSideResourcesSelected = new ArrayList<>();

        centralCardDeck = new GridPane();
        centralCardDeck.setAlignment(Pos.CENTER);
        centralCardDeck.setPadding(new Insets(1, 1, 1, 1));
        centralCardDeck.setHgap(5);
        centralCardDeck.setVgap(5);

        RefreshViewOfCardsOnTable(false);

        leftSideResources = new GridPane();
        leftSideResources.setHgap(20);
        leftSideResources.setVgap(1);
        leftSideResources.setAlignment(Pos.CENTER);

        imageViewListResourcesForTopBox = new ArrayList<>();
        textBanksResources = new ArrayList<>();
        selectedResources = new ArrayList<>();

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

            textBanksResources.add(new Text(playerActions.getTheCentralBankResources().get(i).toString()));
            textBanksResources.get(i).setFont(Font.font("Arial", FontWeight.BOLD, 35));
            imageViewListResourcesForTopBox.add(new ImageView(otherGraphics.getResourcesPics().get(i + 6)));
            topSideResourcesSelected.add(new Text("0"));
            topSideResourcesSelected.get(i).setFont(Font.font("Arial", 25));
            topSideResourcesSelected.get(i).setOpacity(0);
        }

        textHumanScore = new Text("Your score: 0");
        textHumanScore.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textHumanScore.setUnderline(true);

        VBox leftSideFullDeck = new VBox(textHumanScore, leftSideResources);
        leftSideFullDeck.setAlignment(Pos.CENTER);
        leftSideFullDeck.setSpacing(30);

        textComputerScore = new Text("Computer score: 0");
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

        Font buttonsFont = Font.font("Calibre", FontWeight.BOLD, 14);
        int buttonsWidth = 250;
        int buttonHeight = 30;

        Button buyCard = new Button("Buy card");
        buyCard.setPrefWidth(buttonsWidth);
        buyCard.setPrefHeight(buttonHeight);
        buyCard.setFont(buttonsFont);
//        buyCard.setStyle("-fx-background-color: #1c2900; ");
        Button getSelectedRes = new Button("Get selected resources");
        getSelectedRes.setPrefWidth(buttonsWidth);
        getSelectedRes.setPrefHeight(buttonHeight);
        getSelectedRes.setFont(buttonsFont);

        Button resetSelectedRes = new Button("Reset selection");
        resetSelectedRes.setPrefWidth(buttonsWidth);
        resetSelectedRes.setPrefHeight(buttonHeight);
        resetSelectedRes.setFont(buttonsFont);

        VBox res0Vault = new VBox(textBanksResources.get(0), topSideResourcesSelected.get(0));
        VBox res1Vault = new VBox(textBanksResources.get(1), topSideResourcesSelected.get(1));
        VBox res2Vault = new VBox(textBanksResources.get(2), topSideResourcesSelected.get(2));
        VBox res3Vault = new VBox(textBanksResources.get(3), topSideResourcesSelected.get(3));
        VBox res4Vault = new VBox(textBanksResources.get(4), topSideResourcesSelected.get(4));
        VBox res5Vault = new VBox(textBanksResources.get(5), topSideResourcesSelected.get(5));

        HBox selectedResources = new HBox(3,
                imageViewListResourcesForTopBox.get(0), res0Vault,
                imageViewListResourcesForTopBox.get(1), res1Vault,
                imageViewListResourcesForTopBox.get(2), res2Vault,
                imageViewListResourcesForTopBox.get(3), res3Vault,
                imageViewListResourcesForTopBox.get(4), res4Vault,
                imageViewListResourcesForTopBox.get(5), res5Vault);
        selectedResources.setAlignment(Pos.BOTTOM_CENTER);

        HBox buttonsForBuyingResources = new HBox(5, getSelectedRes, resetSelectedRes);
        buttonsForBuyingResources.setAlignment(Pos.BASELINE_CENTER);

        VBox paneForBuyingResources = new VBox(selectedResources, buttonsForBuyingResources);

        VBox fullTable = new VBox(20, paneForBuyingResources, fullDeck);
        fullTable.setBackground(background);
        fullTable.setAlignment(Pos.CENTER);

        scene = new Scene(fullTable, 1728, 972, Color.BLACK);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();

        allVisibleCardsOnTable.get(1).setOnMouseClicked(event -> TryToBuyTheCard(7, allVisibleCardsOnTable.get(1)));
        allVisibleCardsOnTable.get(2).setOnMouseClicked(event -> TryToBuyTheCard(8, allVisibleCardsOnTable.get(2)));
        allVisibleCardsOnTable.get(3).setOnMouseClicked(event -> TryToBuyTheCard(9, allVisibleCardsOnTable.get(3)));
        allVisibleCardsOnTable.get(5).setOnMouseClicked(event -> TryToBuyTheCard(4, allVisibleCardsOnTable.get(5)));
        allVisibleCardsOnTable.get(6).setOnMouseClicked(event -> TryToBuyTheCard(5, allVisibleCardsOnTable.get(6)));
        allVisibleCardsOnTable.get(7).setOnMouseClicked(event -> TryToBuyTheCard(6, allVisibleCardsOnTable.get(7)));
        allVisibleCardsOnTable.get(9).setOnMouseClicked(event -> TryToBuyTheCard(1, allVisibleCardsOnTable.get(9)));
        allVisibleCardsOnTable.get(10).setOnMouseClicked(event -> TryToBuyTheCard(2, allVisibleCardsOnTable.get(10)));
        allVisibleCardsOnTable.get(11).setOnMouseClicked(event -> TryToBuyTheCard(3, allVisibleCardsOnTable.get(11)));

        for(int i=0; i<5; i++) {
            int finalI = i;
            imageViewListResourcesForTopBox.get(i).setOnMouseClicked(event -> PushedButtonAddingResource(finalI));
        }

        resetSelectedRes.setOnMouseClicked(event -> ResetSelected());
        getSelectedRes.setOnMouseClicked(event -> FinalizeAddingNewResources());
    }

    private void TryToBuyTheCard(int cardIndexInTable, ImageView selectedCard) {
        InnerShadow innerShadow = new InnerShadow(70, Color.BLACK);
        selectedCard.setEffect(innerShadow);
        lastSelectedCardToBuy = selectedCard;

        Alert alert = new Alert(Alert.AlertType.NONE, "Do you want to buy the card?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES) {
            playerActions.BuyCard(cardIndexInTable, cardsOnTheGame);
            RefreshViewOfCardsOnTable(true);
            RefreshViewOfOwnedResourcesHuman();
            RefreshViewOfOwnedResourcesComputer();
            RefreshViewOfCostReductionHuman();
            RefreshViewOfBanksResources();
            RefreshViewOfScoreHuman();

        }

        lastSelectedCardToBuy.setEffect(null);
    }


    private void PushedButtonAddingResource(int indexOfSelectedRes) {

        boolean isTransactionFinalized = playerActions.AddSelectedResourceAndCheckIfTransactionCanBeFinalized(indexOfSelectedRes, topSideResourcesSelected.get(indexOfSelectedRes));

        if (!isTransactionFinalized) {
            selectedResources = playerActions.getSelectedResources();
            for (int i = 0; i < selectedResources.size(); i++) {
                topSideResourcesSelected.get(i).setText(selectedResources.get(i).toString());
            }
        }
    }

    private void FinalizeAddingNewResources() {
        playerActions.FinalizeTransactionOfAddingNewResources();

        for (int i = 0; i < selectedResources.size(); i++) {
            topSideResourcesSelected.get(i).setText("0");
            topSideResourcesSelected.get(i).setOpacity(0);
        }
        RefreshViewOfBanksResources();
        RefreshViewOfOwnedResourcesHuman();
        RefreshViewOfOwnedResourcesComputer();
    }

    private void ResetSelected() {
        playerActions.clearSelectedResources();
        for (int i = 0; i < selectedResources.size(); i++) {
            topSideResourcesSelected.get(i).setText("0");
            topSideResourcesSelected.get(i).setOpacity(0);
        }
    }

    public void RefreshViewOfCardsOnTable(boolean isItNotNew) {

        if(isItNotNew) {

            allVisibleCardsOnTable.get(1).setImage(cardsOnTheGame.getCardsOnTable().get(7).getCardGraphic());
            allVisibleCardsOnTable.get(2).setImage(cardsOnTheGame.getCardsOnTable().get(8).getCardGraphic());
            allVisibleCardsOnTable.get(3).setImage(cardsOnTheGame.getCardsOnTable().get(9).getCardGraphic());

            allVisibleCardsOnTable.get(5).setImage(cardsOnTheGame.getCardsOnTable().get(4).getCardGraphic());
            allVisibleCardsOnTable.get(6).setImage(cardsOnTheGame.getCardsOnTable().get(5).getCardGraphic());
            allVisibleCardsOnTable.get(7).setImage(cardsOnTheGame.getCardsOnTable().get(6).getCardGraphic());

            allVisibleCardsOnTable.get(9).setImage(cardsOnTheGame.getCardsOnTable().get(1).getCardGraphic());
            allVisibleCardsOnTable.get(10).setImage(cardsOnTheGame.getCardsOnTable().get(2).getCardGraphic());
            allVisibleCardsOnTable.get(11).setImage(cardsOnTheGame.getCardsOnTable().get(3).getCardGraphic());
            return;
        }

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

    public void RefreshViewOfScoreHuman() {
        textHumanScore.setText("Your score: " + playerActions.getPlayerScore(true));
    }

    public void RefreshViewOfScoreComputer() {
        textHumanScore.setText("Your score: " + playerActions.getPlayerScore(false));
    }

    public void RefreshViewOfCostReductionHuman() {
        List<Integer> freshViewOfCostReduction = playerActions.getPlayerCostReduction(true);
        for(int i=0; i<6; i++) {
            String theValue = freshViewOfCostReduction.get(i).toString();
            leftSideCostReduction.get(i).setText(theValue);
        }
    }

    public void RefreshViewOfBanksResources() {
        for(int i=0; i<6; i++) {
            textBanksResources.get(i).setText(playerActions.getTheCentralBankResources().get(i).toString());
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