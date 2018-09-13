package players;

import bases.*;
import enemies.Enemy;

public class PlayerBullet extends GameOject{
    public PlayerBullet(int x, int y){
        super(x, y);
        renderer = new Animation(
                ImageUtil.load("images/bullet/player/mb70bullet1.png"),
                ImageUtil.load("images/bullet/player/mb70bullet2.png"),
                ImageUtil.load("images/bullet/player/mb70bullet3.png"),
                ImageUtil.load("images/bullet/player/mb70bullet4.png"));
        this.boxCollider = new BoxCollider(x, y , 10 , 20);
    }

    public void run(){
        super.run();
        this.move();
        this.hitEnemies();
        deactivateIfNeeded();
    }

    private void deactivateIfNeeded() {
        if(this.position.y < 0){
            this.isActive = false;
        }
    }

    private void move() {
        this.position.addUp(0, -5);
    }

    private void hitEnemies() {
        Enemy enemy = GameOject.checkCollision(this.boxCollider, Enemy.class);
        if ( enemy != null){
            System.out.println("HIT");
            enemy.getHitEnemies();
            this.destroy();
        }
    }
}