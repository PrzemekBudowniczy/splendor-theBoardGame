package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class OtherGraphics {

    int resourceWidth = 100;
    int resourceHeight = 100;

    int resourceWidthSmall = 60;
    int resourceHeightSmall = 60;

    List<Image> resourcesPics;

    public OtherGraphics() {
        resourcesPics = new ArrayList<>();
        resourcesPics.add(blackRes);
        resourcesPics.add(blueRes);
        resourcesPics.add(greenRes);
        resourcesPics.add(redRes);
        resourcesPics.add(whiteRes);
        resourcesPics.add(goldRes);
        resourcesPics.add(blackResSmall);
        resourcesPics.add(blueResSmall);
        resourcesPics.add(greenResSmall);
        resourcesPics.add(redResSmall);
        resourcesPics.add(whiteResSmall);
        resourcesPics.add(goldResSmall);
    }

    private Image blackRes = new Image("file:src/main/resources/general/black.png", resourceWidth, resourceHeight, false, false);
    private Image blueRes = new Image("file:src/main/resources/general/blue.png", resourceWidth, resourceHeight, false, false);
    private Image greenRes = new Image("file:src/main/resources/general/green.png", resourceWidth, resourceHeight, false, false);
    private Image redRes = new Image("file:src/main/resources/general/red.png", resourceWidth, resourceHeight, false, false);
    private Image whiteRes = new Image("file:src/main/resources/general/white.png", resourceWidth, resourceHeight, false, false);
    private Image goldRes = new Image("file:src/main/resources/general/gold.png", resourceWidth, resourceHeight, false, false);

    private Image blackResSmall = new Image("file:src/main/resources/general/black.png", resourceWidthSmall, resourceHeightSmall, false, false);
    private Image blueResSmall = new Image("file:src/main/resources/general/blue.png", resourceWidthSmall, resourceHeightSmall, false, false);
    private Image greenResSmall = new Image("file:src/main/resources/general/green.png", resourceWidthSmall, resourceHeightSmall, false, false);
    private Image redResSmall = new Image("file:src/main/resources/general/red.png", resourceWidthSmall, resourceHeightSmall, false, false);
    private Image whiteResSmall = new Image("file:src/main/resources/general/white.png", resourceWidthSmall, resourceHeightSmall, false, false);
    private Image goldResSmall = new Image("file:src/main/resources/general/gold.png", resourceWidthSmall, resourceHeightSmall, false, false);

    public List<Image> getResourcesPics() {return resourcesPics;}
}