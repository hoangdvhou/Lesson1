package enemies;

import bases.GameOject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class Enemy extends GameOject {
    EnemyShoot spawnEnemyBullets;

    public Enemy(int x, int y) {
        super(x,y);
        this.position = new Vector2D(x, y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        this.spawnEnemyBullets = new EnemyShoot();

    }

    //Method
    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
    }

    public void run() {
        this.move();
        this.spawnEnemyBullets();
    }

    public void spawnEnemyBullets() {
        spawnEnemyBullets.run(this);

    }

    public void move() {
        Vector2D velocity = new Vector2D();
        velocity.y+=3;
        this.position.addUp(velocity);

    }
}

