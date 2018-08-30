package Players;

import bases.ImageRenderer;
import bases.Vector2D;
import bases.ImageUtil;
import java.awt.*;

public class PlayerBullet {
    int x;
    int y;
    Image image;
    Vector2D position;
    ImageRenderer imageRenderer;


    public PlayerBullet(int x, int y) {
        position = new Vector2D(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");

    }

    public void render(Graphics g) {
        imageRenderer.render(g,this.position);


    }

    public void run() {
        this.move();
    }

    public void move() {
        Vector2D velocity = new Vector2D();
        velocity.y -=10;
        this.position.addUp(velocity);

    }

}
