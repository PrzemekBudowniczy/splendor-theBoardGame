package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;

public class Card {

    private int price1Black;
    private int price2Blue;
    private int price3Green;
    private int price4Red;
    private int price5White;
    private int points;
    private int costReductionColor;
    Image cardGraphic;
    boolean isBlank;

    public Card(int price1Black, int price2Blue, int price3Green, int price4Red, int price5White, int points, int costReductionColor, int setNo, int cardNo, boolean isBlank) {
        this.price1Black = price1Black;
        this.price2Blue = price2Blue;
        this.price3Green = price3Green;
        this.price4Red = price4Red;
        this.price5White = price5White;
        this.points = points;
        this.costReductionColor = costReductionColor;
        cardGraphic = getCardGraphic(isBlank, setNo, cardNo);
        this.isBlank = isBlank;
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

    public int getPrice1Black() {
        return price1Black;
    }

    public int getPrice2Blue() {
        return price2Blue;
    }

    public int getPrice3Green() {
        return price3Green;
    }

    public int getPrice4Red() {
        return price4Red;
    }

    public int getPrice5White() {
        return price5White;
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
