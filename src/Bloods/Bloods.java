package Bloods;

import bases.GameOject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class Bloods extends GameOject {

    public Bloods(int x, int y) {
        super(x,y);
        this.position = new Vector2D();
        this.imageRenderer = new ImageRenderer("images/blood cells/blood-cell1.png");
    }

    @Override
    public void run() {
        super.run();
        this.move();
    }


    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
    }


    private void move() {
        Vector2D velocity = new Vector2D();
        velocity.y+=3;
        velocity.x+=1;
        this.position.addUp(velocity);

    }
}
