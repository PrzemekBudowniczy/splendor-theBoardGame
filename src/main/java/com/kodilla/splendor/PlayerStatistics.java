package com.kodilla.splendor;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatistics {

    private List<Integer> costReduction = new ArrayList<>();
    private List<Integer> resOwned = new ArrayList<>();
    int playerScore;

    public PlayerStatistics() {
        setStartValues();
    }

    public void setStartValues() {

        for(int i=1; i<7; i++) {
            costReduction.add(0);
            resOwned.add(0);
        }
        playerScore = 0;
    }

    public void AddResourcesOwned(List<Integer> resourcesToAdd) {
        for(int i=0; i<resourcesToAdd.size(); i++) {
            resOwned.set(i, resOwned.get(i) + resourcesToAdd.get(i));
        }
    }

    public List<Integer> getCostReduction() {
        return costReduction;
    }

    public List<Integer> getResOwned() {
        return resOwned;
    }

    public void setCostReduction(int theResourceIndex) {
        costReduction.set(theResourceIndex, costReduction.get(theResourceIndex) + 1);
    }

    public void setResOwned(List<Integer> resOwned) {
        this.resOwned = resOwned;
    }

    public void setPlayerScore(int pointsToAdd) {playerScore += pointsToAdd;}

    public int getPlayerScore() {
        return playerScore;
    }
}
