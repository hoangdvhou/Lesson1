package game;

import bases.GameOject;
import bases.ImageRenderer;

public class Background extends GameOject {

    public Background(int x, int y) {
        super(x, y);
        this.renderer = new ImageRenderer("images/background/background.png");

    }
}
