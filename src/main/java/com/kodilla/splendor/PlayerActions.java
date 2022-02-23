package com.kodilla.splendor;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class PlayerActions {

    private List<Integer> selectedResources;
    boolean maximumNumberOfResSelected = false;
    private PlayerStatistics humanPlayer;
    private PlayerStatistics computerPlayer;
    boolean isHumanTurn = true;
//    List<Integer> resOwned;
//    List<Integer> costReduction;
    List<Integer> theCentralBankResources;

    public PlayerActions() {
        selectedResources = new ArrayList<>();
        humanPlayer = new PlayerStatistics();
        computerPlayer = new PlayerStatistics();
        theCentralBankResources = new ArrayList<>();
        settingStartingStateOfResourcesInBankAndInSelectedResources();
    }

    private void settingStartingStateOfResourcesInBankAndInSelectedResources() {
        for(int i=0; i<5; i++) {
            theCentralBankResources.add(4);
            selectedResources.add(0);
        }
        theCentralBankResources.add(5);
    }

    public boolean AddSelectedResourceAndCheckIfTransactionCanBeFinalized(int selection, Text text) {
        int sumOfSelected = 0;
        for(int i=0; i<selectedResources.size(); i++) {
            sumOfSelected += selectedResources.get(i);
            if(selectedResources.get(i) == 2) {
                maximumNumberOfResSelected = true;
                break;
            }
        }
        if(sumOfSelected == 3) {maximumNumberOfResSelected = true;}

        if(maximumNumberOfResSelected == true) {
            Alert alert = new Alert(Alert.AlertType.NONE, "You already selected maximum number of resources. Click 'Get selected resources' to add selected to your vault", ButtonType.CLOSE);
            alert.showAndWait();
            return true;
        }

        if((selectedResources.get(selection) > 0) && (sumOfSelected == 2)) {
            Alert alert = new Alert(Alert.AlertType.NONE, "You need to choose 1 unit from 3 different resources or 2 units of the same resource", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }

        if(theCentralBankResources.get(selection) - selectedResources.get(selection) == 0) {
            text.setOpacity(0);
            Alert alert = new Alert(Alert.AlertType.NONE, "Not enough units of selected resource in central bank", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }

        int sumOfResOwnedAndSelected = numberOfResOwned(true) + sumOfSelected + 1;
        if(sumOfResOwnedAndSelected > 10) {
            System.out.println("resOwned " + numberOfResOwned(true));
            Alert alert = new Alert(Alert.AlertType.NONE, "Maximum number of resources on your vault can be 10 units. You can't add more.", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }

        selectedResources.set(selection, selectedResources.get(selection) + 1);
        text.setOpacity(1);
        return false;
    }

    public void FinalizeTransactionOfAddingNewResources() {
        AddResourcesPlayerStatistics();

        for(int i=0; i<selectedResources.size(); i++) {
            theCentralBankResources.set(i, theCentralBankResources.get(i) - selectedResources.get(i));
        }

        clearSelectedResources();
    }

    public List<Integer> getSelectedResources() {
        return selectedResources;
    }

    public void clearSelectedResources() {
        for(int i=0; i<5; i++) {
            selectedResources.set(i, 0);
        }
        maximumNumberOfResSelected = false;
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

    public List<Integer> getPlayerCostReduction(boolean isItAboutHumanPlayer) {
        if(isItAboutHumanPlayer) {
            return humanPlayer.getCostReduction();
        } else {
            return computerPlayer.getCostReduction();
        }
    }

    public int getPlayerScore(boolean isItAboutHumanPlayer) {
        if(isItAboutHumanPlayer) {
            return humanPlayer.getPlayerScore();
        } else {
            return computerPlayer.getPlayerScore();
        }
    }

    public void BuyCard(int selectedCard, CardsOnTheGame cardsOnTheGame) {

        List<Integer> resOwned;
        List<Integer> costReduction;
        Card theSelectedCard;
        boolean canCardBeBought = true;
        String message;
        System.out.println("human before buy: " + humanPlayer.getResOwned() + " " + humanPlayer.getCostReduction());
        if(isHumanTurn = true) {
            resOwned = humanPlayer.getResOwned();
            costReduction = humanPlayer.getCostReduction();
        } else {
            resOwned = computerPlayer.getResOwned();
            costReduction = computerPlayer.getCostReduction();
        }

        theSelectedCard = cardsOnTheGame.getCardsOnTable().get(selectedCard);

        List<Integer> calculationIfEnoughResourcesToBuy = new ArrayList<>();
        List<Integer> selectedCardCostWithIncludedReductionBonus = new ArrayList<>();
        for(int i=0; i<5; i++) {
            selectedCardCostWithIncludedReductionBonus.add(theSelectedCard.getCardPrice().get(i) - costReduction.get(i));
        }

        for(int i=0; i<selectedCardCostWithIncludedReductionBonus.size(); i++) {
            if(selectedCardCostWithIncludedReductionBonus.get(i) < 0) {
                selectedCardCostWithIncludedReductionBonus.set(i, 0);
            }
        }

        for(int i=0; i < selectedCardCostWithIncludedReductionBonus.size(); i++) {
            calculationIfEnoughResourcesToBuy.add(resOwned.get(i) - selectedCardCostWithIncludedReductionBonus.get(i));
            if(calculationIfEnoughResourcesToBuy.get(i) < 0) {canCardBeBought = false;}
        }

        if (canCardBeBought) {
            for(int i=0; i < selectedCardCostWithIncludedReductionBonus.size(); i++) {
                resOwned.set(i, resOwned.get(i) - selectedCardCostWithIncludedReductionBonus.get(i));
                theCentralBankResources.set(i, theCentralBankResources.get(i) + selectedCardCostWithIncludedReductionBonus.get(i));
            }
            requestUpdateInResOwned(resOwned);
            requestUpdateInCostReduction(theSelectedCard);
            requestAddPointsToPlayerScore(theSelectedCard);
            showAlertOnScreen("You bought the card - the price will be substracted from your vault.");
            System.out.println("selectedCard " + selectedCard);
            cardsOnTheGame.removeBoughtAndDrawNewCard(selectedCard);
            System.out.println("human after buy: " + humanPlayer.getResOwned() + " " + humanPlayer.getCostReduction());
        } else {
            showAlertOnScreen("You don't have enough resources to buy selected card");
            return;
        }

        isHumanTurn = true;
    }

    private void requestAddPointsToPlayerScore(Card theCard) {
        if(isHumanTurn) {
            humanPlayer.setPlayerScore(theCard.getPoints());
        }
    }

    private void requestUpdateInResOwned(List<Integer> resOwned) {
        if(isHumanTurn) {
            humanPlayer.setResOwned(resOwned);
        }
    }

    private void requestUpdateInCostReduction(Card theCard) {
        if(isHumanTurn) {
            int theResourceIndex = theCard.getCostReductionColor() - 1;
            humanPlayer.setCostReduction(theResourceIndex);
        }
    }

    private void showAlertOnScreen(String message) {
        Alert information = new Alert(Alert.AlertType.NONE, message, ButtonType.OK);
        information.showAndWait();
    }

    private int numberOfResOwned(boolean isItAboutHumanPlayer) {
        int numberOfResOwned = 0;
        List<Integer> theResources = getPlayerResourcesOwned(isItAboutHumanPlayer);
        for(int i=0; i<theResources.size(); i++) {
            numberOfResOwned += theResources.get(i);
        }

        return numberOfResOwned;
    }

    public List<Integer> getTheCentralBankResources() {
        return theCentralBankResources;
    }

    //    public String MakeNewEntryInLog() {
//        String logEntry;
//        logEntry = "test event";
//        return logEntry;
//    }
//
//    public void ReserveCard() {
//
//    }
}