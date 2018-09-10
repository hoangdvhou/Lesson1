package players;

import bases.BoxCollider;
import bases.GameOject;
import bases.ImageRenderer;
import enemies.Enemy;

public class PlayerBullet extends GameOject {
    public PlayerBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
        this.boxCollider = new BoxCollider(x,y,10,20);

    }

    public void run() {
        super.run();
        move();
        hitEnemies();
    }

    public void hitEnemies() {
        Enemy enemy = GameOject.checkCollision(this.boxCollider);
        if (enemy != null) {
            System.out.println("Hit");
            enemy.getHitEnemies();
            this.destroy();
        }

    }

    private void move() {
        this.position.addUp(0,-10);

    }
}
