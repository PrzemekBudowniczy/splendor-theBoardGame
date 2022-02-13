package com.kodilla.splendor;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class OtherGraphics {

    int resourceWidth = 100;
    int resourceHeight = 100;

    List<Image> resourcesPics;

    public OtherGraphics() {
        resourcesPics = new ArrayList<>();
        resourcesPics.add(blackRes);
        resourcesPics.add(blueRes);
        resourcesPics.add(greenRes);
        resourcesPics.add(redRes);
        resourcesPics.add(whiteRes);
        resourcesPics.add(goldRes);
    }

    private Image blackRes = new Image("file:src/main/resources/general/black.png", resourceWidth, resourceHeight, false, false);
    private Image blueRes = new Image("file:src/main/resources/general/blue.png", resourceWidth, resourceHeight, false, false);
    private Image greenRes = new Image("file:src/main/resources/general/green.png", resourceWidth, resourceHeight, false, false);
    private Image redRes = new Image("file:src/main/resources/general/red.png", resourceWidth, resourceHeight, false, false);
    private Image whiteRes = new Image("file:src/main/resources/general/white.png", resourceWidth, resourceHeight, false, false);
    private Image goldRes = new Image("file:src/main/resources/general/gold.png", resourceWidth, resourceHeight, false, false);

    public List<Image> getResourcesPics() {
        return resourcesPics;
    }
}
