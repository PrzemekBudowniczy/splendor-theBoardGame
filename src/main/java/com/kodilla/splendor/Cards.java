package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    int cardWidth = 180;
    int cardHeight = 252;

    List<Image> reverses;
    List<Image> cardsSet1;
    List<Image> cardsSet2;
    List<Image> cardsSet3;

    public Cards() {
        reverses = new ArrayList<>();
        for(int i = 1; i<4; i++) {
            reverses.add (new Image("file:src/main/resources/general/" + i + ".reverse.png", cardWidth, cardHeight, false, false));
        }

        cardsSet1 = new ArrayList<>();
        for(int i = 1; i<41; i++) {
            cardsSet1.add (new Image("file:src/main/resources/set1/1." + i + ".jpg", cardWidth, cardHeight, false, false));
        }

        cardsSet2 = new ArrayList<>();
        for(int i = 1; i<31; i++) {
            cardsSet2.add (new Image("file:src/main/resources/set2/2." + i + ".jpg", cardWidth, cardHeight, false, false));
        }

        cardsSet3 = new ArrayList<>();
        for(int i = 1; i<21; i++) {
            cardsSet3.add (new Image("file:src/main/resources/set3/3." + i + ".jpg", cardWidth, cardHeight, false, false));
        }
    }

    public List<Image> getReverses() {
        return reverses;
    }

    public List<Image> getCardsSet1() {
        return cardsSet1;
    }

    public List<Image> getCardsSet2() {
        return cardsSet2;
    }

    public List<Image> getCardsSet3() {
        return cardsSet3;
    }
}
