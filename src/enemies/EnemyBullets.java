package enemies;

import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;

public class EnemyBullets {
    int x,y;
    Image image;
    Vector2D position;
    ImageRenderer imageRenderer;

    public EnemyBullets(int x, int y){
        position = new Vector2D(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
    }

    public void render(Graphics g) {
        imageRenderer.render(g,position);

    }
    public void run() {
        this.move();
    }

    private void move() {
        Vector2D velocity = new Vector2D();
        velocity.y += 5;
        this.position.addUp(velocity);

    }

}
