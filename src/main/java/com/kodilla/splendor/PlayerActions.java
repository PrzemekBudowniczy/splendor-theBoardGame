package com.kodilla.splendor;

import java.util.ArrayList;
import java.util.List;

public class PlayerActions {

    List<Integer> selectedResources;
    PlayerStatistics humanPlayer;
    PlayerStatistics computerPlayer;

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

    public void BuyCard() {

    }

    public void ReserveCard() {

    }
}
