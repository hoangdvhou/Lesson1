package game;

import bases.GameOject;
import bases.ImageRenderer;

import java.awt.*;

public class Background extends GameOject {

    public Background(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/background/background.png");

    }
}
