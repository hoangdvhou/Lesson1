package enemies;

import bases.BoxCollider;
import bases.GameOject;
import bases.ImageRenderer;
import bases.Vector2D;
import players.Player;

import java.awt.*;

public class Enemy extends GameOject {
    EnemyShoot spawnEnemyBullets;
    EnemyBullets enemyBullets;

    public Enemy(int x, int y) {
        super(x, y);
        this.position = new Vector2D(x, y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        this.spawnEnemyBullets = new EnemyShoot();
        this.boxCollider = new BoxCollider(x, y, 30, 30);
        enemyBullets = new EnemyBullets(30,30);

    }


    public void run() {
        super.run();
        this.move();
        this.spawnEnemyBullets();
        enemyBullets.hitPlayer();
    }

    public void spawnEnemyBullets() {
        spawnEnemyBullets.run(this);

    }

    public void move() {
        Vector2D velocity = new Vector2D();
        velocity.y += 3;
        this.position.addUp(velocity);

    }

    public void getHitEnemies() {
        this.destroy();
    }
}


