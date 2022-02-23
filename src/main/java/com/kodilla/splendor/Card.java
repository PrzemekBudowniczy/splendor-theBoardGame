package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private int points;
    private int costReductionColor;
    List<Integer> price;
    Image cardGraphic;
    boolean isBlank;

    public Card(int price1Black, int price2Blue, int price3Green, int price4Red, int price5White, int points, int costReductionColor, int setNo, int cardNo, boolean isBlank) {
        price = new ArrayList<>();
        price.add(price1Black);
        price.add(price2Blue);
        price.add(price3Green);
        price.add(price4Red);
        price.add(price5White);
        this.points = points;
        this.costReductionColor = costReductionColor;
        cardGraphic = getCardGraphic(isBlank, setNo, cardNo);
        this.isBlank = isBlank;
    }

    public Card(boolean isBlank, int setNo, int cardNo) {
        cardGraphic = getCardGraphic(true, setNo, cardNo);
    }

    private Image getCardGraphic(boolean isBlank, int setNo, int cardNo) {
        Image theCardGraphic;
        if(isBlank) {
            theCardGraphic = new Image("file:src/main/resources/general/emptySlot.png", 180, 252, false, false);
        } else {
            theCardGraphic = new Image("file:src/main/resources/set" + setNo + "/" + setNo + "." + cardNo + ".jpg", 180, 252, false, false);
        }
        return theCardGraphic;
    }

    public List<Integer> getCardPrice() {
        return price;
    }

    public int getPoints() {
        return points;
    }

    public int getCostReductionColor() {
        return costReductionColor;
    }

    public Image getCardGraphic() {
        return cardGraphic;
    }

    public boolean isBlank() {
        return isBlank;
    }
}