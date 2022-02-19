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
        for(int i=0; i<3; i++) {
            int indexOfResourceToAdd = resourcesToAdd.get(i) - 1;
            resOwned.set(indexOfResourceToAdd, resOwned.get(indexOfResourceToAdd) + 1);
        }
//        System.out.println(resOwned.toString());
    }

    public List<Integer> getCostReduction() {
        return costReduction;
    }

    public List<Integer> getResOwned() {
        return resOwned;
    }

    public void setCostReduction(List<Integer> costReduction) {
        this.costReduction = costReduction;
    }

    public void setResOwned(List<Integer> resOwned) {
        this.resOwned = resOwned;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
