package com.kodilla.splendor;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.List;

public class PlayerActions {

    private List<Integer> selectedResources;
    private PlayerStatistics humanPlayer;
    private PlayerStatistics computerPlayer;
    boolean isHumanTurn = true;
    List<Integer> resOwned;
    List<Integer> costReduction;

    public PlayerActions() {
        selectedResources = new ArrayList<>();
        humanPlayer = new PlayerStatistics();
        computerPlayer = new PlayerStatistics();
    }

    public boolean AddSelectedResourceAndCheckIfTransactionFinalized(int selection) {
        selectedResources.add(selection);
        if(selectedResources.size() == 3) {
            AddResourcesPlayerStatistics();
            clearSelectedResources();
            return true;
        } else {
            return false;
        }
    }

    public void clearSelectedResources() {
        selectedResources.clear();
    }

    private void AddResourcesPlayerStatistics() {
        humanPlayer.AddResourcesOwned(selectedResources);
    }

    public List<Integer> getPlayerResourcesOwned(boolean isItAboutHumanPlayer) {
        if(isItAboutHumanPlayer) {
            return humanPlayer.getResOwned();
        } else {
            return computerPlayer.getResOwned();
        }
    }

    public void BuyCard(int selectedCard, CardsOnTheGame cardsOnTheGame) {

        Card theSelectedCard;
        boolean canCardBeBought = true;
        String message;

        if(isHumanTurn = true) {
            resOwned = humanPlayer.getResOwned();
            costReduction = humanPlayer.getCostReduction();
        } else {
            resOwned = computerPlayer.getResOwned();
            costReduction = computerPlayer.getCostReduction();
        }

        theSelectedCard = cardsOnTheGame.getCardsOnTable().get(selectedCard);

        System.out.println(resOwned.toString());  //1
//        System.out.println(theSelectedCard.toString());

        List<Integer> calculationIfEnoughResourcesToBuy = new ArrayList<>();
        List<Integer> selectedCardCostWithIncludedReductionBonus = new ArrayList<>();
        selectedCardCostWithIncludedReductionBonus.add(theSelectedCard.getPrice1Black() - costReduction.get(0));
        selectedCardCostWithIncludedReductionBonus.add(theSelectedCard.getPrice2Blue() - costReduction.get(1));
        selectedCardCostWithIncludedReductionBonus.add(theSelectedCard.getPrice3Green() - costReduction.get(2));
        selectedCardCostWithIncludedReductionBonus.add(theSelectedCard.getPrice4Red() - costReduction.get(3));
        selectedCardCostWithIncludedReductionBonus.add(theSelectedCard.getPrice5White() - costReduction.get(4));
        System.out.println(theSelectedCard.getPrice1Black() + ", " + theSelectedCard.getPrice2Blue() + ", " + theSelectedCard.getPrice3Green() + ", " + theSelectedCard.getPrice4Red() + ", " + theSelectedCard.getPrice5White());
        //2

        if(canCardBeBought) {System.out.println("true");}
        else {System.out.println("false");} //3
        System.out.println(selectedCardCostWithIncludedReductionBonus.toString());  //4
        System.out.println(resOwned.toString());  //5

        for(int i=0; i < selectedCardCostWithIncludedReductionBonus.size(); i++) {
            calculationIfEnoughResourcesToBuy.add(resOwned.get(i) - selectedCardCostWithIncludedReductionBonus.get(i));
            if(calculationIfEnoughResourcesToBuy.get(i) < 0) {canCardBeBought = false;}
        }

        if (canCardBeBought) {
            for(int i=0; i < selectedCardCostWithIncludedReductionBonus.size(); i++) {
                resOwned.set(i, resOwned.get(i) - selectedCardCostWithIncludedReductionBonus.get(i));
            }
            requestUpdateInResOwned();
            showAlertOnScreen("You bought the card - the price will be substracted from your vault");
        } else {
            showAlertOnScreen("You don't have enough resources to buy selected card");
            return;
        }

//        if(canCardBeBought) {System.out.println("true");}
//        System.out.println(selectedCardCostWithIncludedReductionBonus.toString());  //6
//        System.out.println(resOwned.toString());  //7

        isHumanTurn = true;
    }

    private void requestUpdateInResOwned() {
        if(isHumanTurn) {
            humanPlayer.setResOwned(resOwned);
        }
    }

    private void showAlertOnScreen(String message) {
        Alert information = new Alert(Alert.AlertType.NONE, message, ButtonType.OK);
        information.showAndWait();
    }

    public String MakeNewEntryInLog() {
        String logEntry;
        logEntry = "test event";
        return logEntry;
    }

    public void ReserveCard() {

    }
}
