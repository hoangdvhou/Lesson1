package enemies;

import bases.*;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends GameOject {
    EnemyShoot spawnEnemyBullets;
    EnemyBullets enemyBullets;

    public Enemy(int x, int y) {
        super(x, y);
        //ArrayList<Image> images = new ArrayList<>();

        this.position = new Vector2D(x, y);
        this.renderer = new Animation(
                ImageUtil.load("images/enemy/bacteria/bacteria1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria3.png"));
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
        EnemyExplosion explosion = new EnemyExplosion(
                (int)this.position.x,
                (int)this.position.y
        );
        GameOject.add(explosion);
    }
}


