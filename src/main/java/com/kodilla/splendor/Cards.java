package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    int cardWidth = 150;
    int cardHeight = 210;

    List<Image> reverses;
    List<Image> cardsSet1;
    List<Image> cardsSet2;
    List<Image> cardsSet3;

    public Cards() {
        reverses = new ArrayList<>();
        reverses.add(reverse1);
        reverses.add(reverse2);
        reverses.add(reverse3);

        cardsSet1 = new ArrayList<>();
        cardsSet1.add(cardS1N1);
        cardsSet1.add(cardS1N2);
        cardsSet1.add(cardS1N3);
        cardsSet1.add(cardS1N4);
        cardsSet1.add(cardS1N5);
        cardsSet1.add(cardS1N6);
        cardsSet1.add(cardS1N7);
        cardsSet1.add(cardS1N8);
        cardsSet1.add(cardS1N9);
        cardsSet1.add(cardS1N10);
        cardsSet1.add(cardS1N11);
        cardsSet1.add(cardS1N12);
        cardsSet1.add(cardS1N13);
        cardsSet1.add(cardS1N14);
        cardsSet1.add(cardS1N15);
        cardsSet1.add(cardS1N16);
        cardsSet1.add(cardS1N17);
        cardsSet1.add(cardS1N18);
        cardsSet1.add(cardS1N19);
        cardsSet1.add(cardS1N20);
        cardsSet1.add(cardS1N21);
        cardsSet1.add(cardS1N22);
        cardsSet1.add(cardS1N23);
        cardsSet1.add(cardS1N24);
        cardsSet1.add(cardS1N25);
        cardsSet1.add(cardS1N26);
        cardsSet1.add(cardS1N27);
        cardsSet1.add(cardS1N28);
        cardsSet1.add(cardS1N29);
        cardsSet1.add(cardS1N30);
        cardsSet1.add(cardS1N31);
        cardsSet1.add(cardS1N32);
        cardsSet1.add(cardS1N33);
        cardsSet1.add(cardS1N34);
        cardsSet1.add(cardS1N35);
        cardsSet1.add(cardS1N36);
        cardsSet1.add(cardS1N37);
        cardsSet1.add(cardS1N38);
        cardsSet1.add(cardS1N39);
        cardsSet1.add(cardS1N40);

        cardsSet2 = new ArrayList<>();
        cardsSet2.add(cardS2N1);
        cardsSet2.add(cardS2N2);
        cardsSet2.add(cardS2N3);
        cardsSet2.add(cardS2N4);
        cardsSet2.add(cardS2N5);
        cardsSet2.add(cardS2N6);
        cardsSet2.add(cardS2N7);
        cardsSet2.add(cardS2N8);
        cardsSet2.add(cardS2N9);
        cardsSet2.add(cardS2N10);
        cardsSet2.add(cardS2N11);
        cardsSet2.add(cardS2N12);
        cardsSet2.add(cardS2N13);
        cardsSet2.add(cardS2N14);
        cardsSet2.add(cardS2N15);
        cardsSet2.add(cardS2N16);
        cardsSet2.add(cardS2N17);
        cardsSet2.add(cardS2N18);
        cardsSet2.add(cardS2N19);
        cardsSet2.add(cardS2N20);
        cardsSet2.add(cardS2N21);
        cardsSet2.add(cardS2N22);
        cardsSet2.add(cardS2N23);
        cardsSet2.add(cardS2N24);
        cardsSet2.add(cardS2N25);
        cardsSet2.add(cardS2N26);
        cardsSet2.add(cardS2N27);
        cardsSet2.add(cardS2N28);
        cardsSet2.add(cardS2N29);
        cardsSet2.add(cardS2N30);

        cardsSet3 = new ArrayList<>();
        cardsSet3.add(cardS3N1);
        cardsSet3.add(cardS3N2);
        cardsSet3.add(cardS3N3);
        cardsSet3.add(cardS3N4);
        cardsSet3.add(cardS3N5);
        cardsSet3.add(cardS3N6);
        cardsSet3.add(cardS3N7);
        cardsSet3.add(cardS3N8);
        cardsSet3.add(cardS3N9);
        cardsSet3.add(cardS3N10);
        cardsSet3.add(cardS3N11);
        cardsSet3.add(cardS3N12);
        cardsSet3.add(cardS3N13);
        cardsSet3.add(cardS3N14);
        cardsSet3.add(cardS3N15);
        cardsSet3.add(cardS3N16);
        cardsSet3.add(cardS3N17);
        cardsSet3.add(cardS3N18);
        cardsSet3.add(cardS3N19);
        cardsSet3.add(cardS3N20);
    }

    // reverses for cards
    private Image reverse1 = new Image("file:src/main/resources/general/1.reverse.png", cardWidth, cardHeight, false, false);
    private Image reverse2 = new Image("file:src/main/resources/general/2.reverse.png", cardWidth, cardHeight, false, false);
    private Image reverse3 = new Image("file:src/main/resources/general/3.reverse.png", cardWidth, cardHeight, false, false);

    // set 1 of cards
    private Image cardS1N1 = new Image("file:src/main/resources/set1/1.1.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N2 = new Image("file:src/main/resources/set1/1.2.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N3 = new Image("file:src/main/resources/set1/1.3.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N4 = new Image("file:src/main/resources/set1/1.4.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N5 = new Image("file:src/main/resources/set1/1.5.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N6 = new Image("file:src/main/resources/set1/1.6.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N7 = new Image("file:src/main/resources/set1/1.7.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N8 = new Image("file:src/main/resources/set1/1.8.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N9 = new Image("file:src/main/resources/set1/1.9.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N10 = new Image("file:src/main/resources/set1/1.10.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N11 = new Image("file:src/main/resources/set1/1.11.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N12 = new Image("file:src/main/resources/set1/1.12.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N13 = new Image("file:src/main/resources/set1/1.13.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N14 = new Image("file:src/main/resources/set1/1.14.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N15 = new Image("file:src/main/resources/set1/1.15.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N16 = new Image("file:src/main/resources/set1/1.16.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N17 = new Image("file:src/main/resources/set1/1.17.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N18 = new Image("file:src/main/resources/set1/1.18.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N19 = new Image("file:src/main/resources/set1/1.19.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N20 = new Image("file:src/main/resources/set1/1.20.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N21 = new Image("file:src/main/resources/set1/1.21.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N22 = new Image("file:src/main/resources/set1/1.22.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N23 = new Image("file:src/main/resources/set1/1.23.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N24 = new Image("file:src/main/resources/set1/1.24.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N25 = new Image("file:src/main/resources/set1/1.25.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N26 = new Image("file:src/main/resources/set1/1.26.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N27 = new Image("file:src/main/resources/set1/1.27.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N28 = new Image("file:src/main/resources/set1/1.28.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N29 = new Image("file:src/main/resources/set1/1.29.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N30 = new Image("file:src/main/resources/set1/1.30.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N31 = new Image("file:src/main/resources/set1/1.31.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N32 = new Image("file:src/main/resources/set1/1.32.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N33 = new Image("file:src/main/resources/set1/1.33.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N34 = new Image("file:src/main/resources/set1/1.34.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N35 = new Image("file:src/main/resources/set1/1.35.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N36 = new Image("file:src/main/resources/set1/1.36.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N37 = new Image("file:src/main/resources/set1/1.37.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N38 = new Image("file:src/main/resources/set1/1.38.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N39 = new Image("file:src/main/resources/set1/1.39.jpg", cardWidth, cardHeight, false, false);
    private Image cardS1N40 = new Image("file:src/main/resources/set1/1.40.jpg", cardWidth, cardHeight, false, false);

    // set 2 of cards
    private Image cardS2N1 = new Image("file:src/main/resources/set2/2.1.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N2 = new Image("file:src/main/resources/set2/2.2.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N3 = new Image("file:src/main/resources/set2/2.3.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N4 = new Image("file:src/main/resources/set2/2.4.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N5 = new Image("file:src/main/resources/set2/2.5.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N6 = new Image("file:src/main/resources/set2/2.6.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N7 = new Image("file:src/main/resources/set2/2.7.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N8 = new Image("file:src/main/resources/set2/2.8.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N9 = new Image("file:src/main/resources/set2/2.9.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N10 = new Image("file:src/main/resources/set2/2.10.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N11 = new Image("file:src/main/resources/set2/2.11.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N12 = new Image("file:src/main/resources/set2/2.12.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N13 = new Image("file:src/main/resources/set2/2.13.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N14 = new Image("file:src/main/resources/set2/2.14.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N15 = new Image("file:src/main/resources/set2/2.15.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N16 = new Image("file:src/main/resources/set2/2.16.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N17 = new Image("file:src/main/resources/set2/2.17.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N18 = new Image("file:src/main/resources/set2/2.18.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N19 = new Image("file:src/main/resources/set2/2.19.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N20 = new Image("file:src/main/resources/set2/2.20.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N21 = new Image("file:src/main/resources/set2/2.21.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N22 = new Image("file:src/main/resources/set2/2.22.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N23 = new Image("file:src/main/resources/set2/2.23.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N24 = new Image("file:src/main/resources/set2/2.24.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N25 = new Image("file:src/main/resources/set2/2.25.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N26 = new Image("file:src/main/resources/set2/2.26.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N27 = new Image("file:src/main/resources/set2/2.27.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N28 = new Image("file:src/main/resources/set2/2.28.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N29 = new Image("file:src/main/resources/set2/2.29.jpg", cardWidth, cardHeight, false, false);
    private Image cardS2N30 = new Image("file:src/main/resources/set2/2.30.jpg", cardWidth, cardHeight, false, false);

    // set 3 of cards
    private Image cardS3N1 = new Image("file:src/main/resources/set3/3.1.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N2 = new Image("file:src/main/resources/set3/3.2.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N3 = new Image("file:src/main/resources/set3/3.3.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N4 = new Image("file:src/main/resources/set3/3.4.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N5 = new Image("file:src/main/resources/set3/3.5.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N6 = new Image("file:src/main/resources/set3/3.6.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N7 = new Image("file:src/main/resources/set3/3.7.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N8 = new Image("file:src/main/resources/set3/3.8.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N9 = new Image("file:src/main/resources/set3/3.9.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N10 = new Image("file:src/main/resources/set3/3.10.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N11 = new Image("file:src/main/resources/set3/3.11.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N12 = new Image("file:src/main/resources/set3/3.12.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N13 = new Image("file:src/main/resources/set3/3.13.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N14 = new Image("file:src/main/resources/set3/3.14.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N15 = new Image("file:src/main/resources/set3/3.15.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N16 = new Image("file:src/main/resources/set3/3.16.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N17 = new Image("file:src/main/resources/set3/3.17.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N18 = new Image("file:src/main/resources/set3/3.18.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N19 = new Image("file:src/main/resources/set3/3.19.jpg", cardWidth, cardHeight, false, false);
    private Image cardS3N20 = new Image("file:src/main/resources/set3/3.20.jpg", cardWidth, cardHeight, false, false);

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
