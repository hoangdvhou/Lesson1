package enemies;

import bases.ImageRenderer;
import bases.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Enemy extends JPanel {
    ImageRenderer imageRenderer;
    int x;
    int y;
    Image image;
    Vector2D position;
    public ArrayList<EnemyBullets> bullets = new ArrayList<>();
    EnemyShoot spawnEnemy;

    public Enemy(int x, int y) {
        this.position = new Vector2D(x, y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        this.spawnEnemy = new EnemyShoot();

    }

    //Method
    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
    }

    public void run() {
        this.move();
        this.spawnEnemy();
    }

    public void spawnEnemy() {
        spawnEnemy.run(this);

    }

    public void move() {
        Vector2D velocity = new Vector2D();
        velocity.y+=3;
        this.position.addUp(velocity);

    }
}

