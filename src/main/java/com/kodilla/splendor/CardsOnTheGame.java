package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardsOnTheGame {
    List<Card> set1CardDeck = new ArrayList<>();
    List<Card> set2CardDeck = new ArrayList<>();
    List<Card> set3CardDeck = new ArrayList<>();
    List<Image> reverseForDeck = new ArrayList<>();

    CardsGraphics cardsGraphics = new CardsGraphics();

    Map<Integer, Card> cardsOnTable = new HashMap<>();

    public CardsOnTheGame() {
        GenerateSetsOfCards();
        DrawAllCardsAtStart();
    }

    public Card DrawCard(int setNo) {

        Card theResultCard;
        if(setNo == 1) {
            if(checkIfNoMoreCardsOnDeck(1)) {return new Card(true, 1, 1);}
            int randomCardNumber = (int) (Math.random() * (set1CardDeck.size()));
            System.out.println(randomCardNumber);
            theResultCard = set1CardDeck.get(randomCardNumber);
            set1CardDeck.remove(randomCardNumber);
        } else if(setNo == 2) {
            if(checkIfNoMoreCardsOnDeck(2)) {return new Card(true, 1, 1);}
            int randomCardNumber = (int) (Math.random() * (set2CardDeck.size()));
            theResultCard = set2CardDeck.get(randomCardNumber);
            set2CardDeck.remove(randomCardNumber);
        } else {
            if(checkIfNoMoreCardsOnDeck(3)) {return new Card(true, 1, 1);}
            int randomCardNumber = (int) (Math.random() * (set3CardDeck.size()));
            theResultCard = set3CardDeck.get(randomCardNumber);
            set3CardDeck.remove(randomCardNumber);
        }
        return theResultCard;
    }

    private boolean checkIfNoMoreCardsOnDeck(int setNo) {
        if(setNo == 1 && set1CardDeck.size() == 0) {
            return true;
        } else if(setNo == 2 && set2CardDeck.size() == 0) {
            return true;
        } else if(setNo == 3 && set3CardDeck.size() == 0) {
            return true;
        }
        return false;
    }

    public void PutNewCardOnTable(int setNo, int positionInTable) {
        cardsOnTable.put((setNo*3 - 3) + positionInTable, DrawCard(setNo));
    }

    public void ReplaceCardOnTable(int setNo, int positionInTable) {
        cardsOnTable.replace((setNo*3 - 3) + positionInTable, DrawCard(setNo));
    }

    public Map<Integer, Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public List<Image> getReverseForDeck() {
        return reverseForDeck;
    }

    private Card generateEmptyCard(int setNo) {
        return new Card(0,0,0,0,0,0,0,setNo,0, true);
    }

    public void DrawAllCardsAtStart() {
        for(int x=1; x<4; x++) {
            reverseForDeck.add(cardsGraphics.getCardReverseImages().get(x-1));
            for(int y=1; y<4; y++) {
                PutNewCardOnTable(x, y);
            }
        }
    }

    public void removeBoughtAndDrawNewCard(int cardIndexInTable) {
        int setNo;
        int positionInTable;
        if(cardIndexInTable<4) {
            setNo = 1;
            positionInTable = cardIndexInTable;
        } else if(cardIndexInTable < 7) {
            setNo = 2;
            positionInTable = cardIndexInTable - 3;
        } else {
            setNo = 3;
            positionInTable = cardIndexInTable - 6;
        }
        System.out.println("setNo " + setNo + " position " + positionInTable);
        ReplaceCardOnTable(setNo, positionInTable);
    }

    private void GenerateSetsOfCards() {
        set1CardDeck.add(new Card(0,3,1,0,1,0,3,1,1,false));
        set1CardDeck.add(new Card(0,2,0,2,0,0,3,1,2,false));
        set1CardDeck.add(new Card(3,0,0,0,0,0,2,1,3,false));
        set1CardDeck.add(new Card(0,0,0,4,0,1,2,1,4,false));
        set1CardDeck.add(new Card(2,0,2,0,0,0,2,1,5,false));
        set1CardDeck.add(new Card(2,0,0,0,1,0,2,1,6,false));
        set1CardDeck.add(new Card(2,1,0,1,1,0,3,1,7,false));
        set1CardDeck.add(new Card(0,0,4,0,0,1,5,1,8,false));
        set1CardDeck.add(new Card(1,0,0,2,0,0,5,1,9,false));
        set1CardDeck.add(new Card(1,2,2,0,0,0,5,1,10,false));
        set1CardDeck.add(new Card(2,2,0,0,0,0,5,1,11,false));
        set1CardDeck.add(new Card(1,0,1,3,0,0,1,1,12,false));
        set1CardDeck.add(new Card(0,2,1,1,1,0,1,1,13,false));
        set1CardDeck.add(new Card(1,1,1,0,1,0,4,1,14,false));
        set1CardDeck.add(new Card(0,0,0,0,3,0,4,1,15,false));
        set1CardDeck.add(new Card(0,2,1,0,0,0,4,1,16,false));
        set1CardDeck.add(new Card(1,0,1,1,1,0,2,1,17,false));
        set1CardDeck.add(new Card(0,0,2,2,1,0,2,1,18,false));
        set1CardDeck.add(new Card(1,0,1,1,1,0,2,1,19,false));
        set1CardDeck.add(new Card(0,1,0,0,2,0,3,1,20,false));
        set1CardDeck.add(new Card(0,0,2,0,2,0,1,1,21,false));
        set1CardDeck.add(new Card(0,1,3,1,0,0,2,1,22,false));
        set1CardDeck.add(new Card(3,0,0,1,1,0,4,1,23,false));
        set1CardDeck.add(new Card(0,0,0,0,4,1,4,1,24,false));
        set1CardDeck.add(new Card(1,1,1,1,0,0,5,1,25,false));
        set1CardDeck.add(new Card(1,1,0,0,3,0,5,1,26,false));
        set1CardDeck.add(new Card(1,1,2,1,0,0,5,1,27,false));
        set1CardDeck.add(new Card(2,1,0,2,0,0,3,1,28,false));
        set1CardDeck.add(new Card(0,0,0,3,0,0,3,1,29,false));
        set1CardDeck.add(new Card(0,0,3,0,0,0,1,1,30,false));
        set1CardDeck.add(new Card(0,0,2,1,0,0,1,1,31,false));
        set1CardDeck.add(new Card(0,2,0,1,2,0,1,1,32,false));
        set1CardDeck.add(new Card(1,1,0,1,1,0,3,1,33,false));
        set1CardDeck.add(new Card(4,0,0,0,0,1,3,1,34,false));
        set1CardDeck.add(new Card(0,0,0,2,2,0,4,1,35,false));
        set1CardDeck.add(new Card(1,1,1,0,2,0,4,1,36,false));
        set1CardDeck.add(new Card(2,0,1,0,2,0,4,1,37,false));
        set1CardDeck.add(new Card(0,1,1,1,1,0,1,1,38,false));
        set1CardDeck.add(new Card(0,4,0,0,0,1,1,1,39,false));
        set1CardDeck.add(new Card(0,3,0,0,0,0,5,1,40,false));

        set2CardDeck.add(new Card(0,0,0,0,5,2,1,2,1,false));
        set2CardDeck.add(new Card(0,0,5,3,0,2,1,2,2,false));
        set2CardDeck.add(new Card(0,0,2,3,3,1,3,2,3,false));
        set2CardDeck.add(new Card(5,0,0,0,3,2,4,2,4,false));
        set2CardDeck.add(new Card(0,1,4,2,0,2,1,2,5,false));
        set2CardDeck.add(new Card(0,0,0,0,6,3,5,2,6,false));
        set2CardDeck.add(new Card(4,0,0,1,2,2,2,2,7,false));
        set2CardDeck.add(new Card(0,3,0,0,5,2,2,2,8,false));
        set2CardDeck.add(new Card(3,2,3,0,0,1,2,2,9,false));
        set2CardDeck.add(new Card(0,3,0,3,2,1,5,2,10,false));
        set2CardDeck.add(new Card(2,3,0,0,2,1,3,2,11,false));
        set2CardDeck.add(new Card(0,2,2,0,3,1,1,2,12,false));
        set2CardDeck.add(new Card(2,0,3,0,3,1,1,2,13,false));
        set2CardDeck.add(new Card(2,0,1,4,0,2,5,2,14,false));
        set2CardDeck.add(new Card(5,0,0,0,0,2,4,2,15,false));
        set2CardDeck.add(new Card(3,0,0,2,2,1,4,2,16,false));
        set2CardDeck.add(new Card(6,0,0,0,0,3,1,2,17,false));
        set2CardDeck.add(new Card(2,0,3,2,0,1,5,2,18,false));
        set2CardDeck.add(new Card(0,0,5,0,0,2,3,2,19,false));
        set2CardDeck.add(new Card(0,0,0,5,0,2,5,2,20,false));
        set2CardDeck.add(new Card(0,4,2,0,1,2,4,2,21,false));
        set2CardDeck.add(new Card(0,5,0,0,0,2,2,2,22,false));
        set2CardDeck.add(new Card(0,2,2,3,0,1,2,2,23,false));
        set2CardDeck.add(new Card(0,5,3,0,0,2,3,2,24,false));
        set2CardDeck.add(new Card(3,0,0,5,0,2,5,2,25,false));
        set2CardDeck.add(new Card(0,0,0,6,0,3,4,2,26,false));
        set2CardDeck.add(new Card(0,0,6,0,0,3,3,2,27,false));
        set2CardDeck.add(new Card(1,2,0,0,4,2,3,2,28,false));
        set2CardDeck.add(new Card(0,6,0,0,0,3,2,2,29,false));
        set2CardDeck.add(new Card(4,3,0,2,0,1,4,2,30,false));

        set3CardDeck.add(new Card(3,0,3,6,0,4,1,3,1,false));
        set3CardDeck.add(new Card(0,7,3,0,0,5,3,3,2,false));
        set3CardDeck.add(new Card(6,0,0,3,3,4,5,3,3,false));
        set3CardDeck.add(new Card(3,3,3,5,0,3,5,3,4,false));
        set3CardDeck.add(new Card(3,3,0,3,5,3,3,3,5,false));
        set3CardDeck.add(new Card(3,0,0,7,0,5,1,3,6,false));
        set3CardDeck.add(new Card(7,0,0,0,0,4,5,3,7,false));
        set3CardDeck.add(new Card(0,6,3,0,3,4,3,3,8,false));
        set3CardDeck.add(new Card(0,0,0,7,0,4,1,3,9,false));
        set3CardDeck.add(new Card(7,0,0,0,3,5,5,3,10,false));
        set3CardDeck.add(new Card(0,7,0,0,0,4,3,3,11,false));
        set3CardDeck.add(new Card(0,3,5,3,3,3,1,3,12,false));
        set3CardDeck.add(new Card(0,0,0,0,7,4,2,3,13,false));
        set3CardDeck.add(new Card(3,5,3,0,3,3,4,3,14,false));
        set3CardDeck.add(new Card(3,3,0,0,6,4,2,3,15,false));
        set3CardDeck.add(new Card(5,0,3,3,3,3,2,3,16,false));
        set3CardDeck.add(new Card(0,0,7,0,0,4,4,3,17,false));
        set3CardDeck.add(new Card(0,0,7,3,0,5,4,3,18,false));
        set3CardDeck.add(new Card(0,3,0,0,7,5,2,3,19,false));
        set3CardDeck.add(new Card(0,3,6,3,0,4,4,3,20,false));
    }
}