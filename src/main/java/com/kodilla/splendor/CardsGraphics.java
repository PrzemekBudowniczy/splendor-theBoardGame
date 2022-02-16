package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class CardsGraphics {

    int cardWidth = 180;
    int cardHeight = 252;

    List<Image> cardReverseImages;
    List<Image> cardsSet1Images;
    List<Image> cardsSet2Images;
    List<Image> cardsSet3Images;

    public CardsGraphics() {
        cardReverseImages = new ArrayList<>();
        for(int i = 1; i<4; i++) {
            cardReverseImages.add (new Image("file:src/main/resources/general/" + i + ".reverse.png", cardWidth, cardHeight, false, false));
        }

        cardsSet1Images = new ArrayList<>();
        for(int i = 1; i<41; i++) {
            cardsSet1Images.add (new Image("file:src/main/resources/set1/1." + i + ".jpg", cardWidth, cardHeight, false, false));
        }

        cardsSet2Images = new ArrayList<>();
        for(int i = 1; i<31; i++) {
            cardsSet2Images.add (new Image("file:src/main/resources/set2/2." + i + ".jpg", cardWidth, cardHeight, false, false));
        }

        cardsSet3Images = new ArrayList<>();
        for(int i = 1; i<21; i++) {
            cardsSet3Images.add (new Image("file:src/main/resources/set3/3." + i + ".jpg", cardWidth, cardHeight, false, false));
        }
    }

    public List<Image> getCardReverseImages() {
        return cardReverseImages;
    }

    public List<Image> getCardsSet1Images() {
        return cardsSet1Images;
    }

    public List<Image> getCardsSet2Images() {
        return cardsSet2Images;
    }

    public List<Image> getCardsSet3Images() {
        return cardsSet3Images;
    }
}
