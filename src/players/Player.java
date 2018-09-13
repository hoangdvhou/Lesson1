package players;
import bases.*;
import enemies.Enemy;

import java.util.ArrayList;

public class Player extends GameOject {
    PlayerMove playerMove;
    public ArrayList bullets;//shoot
    PlayerShoot playerShoot;
    PlayerBullet playerBullet;

    public Player(int x,int y){
        super(x,y);
        playerShoot = new PlayerShoot();
        renderer = new Animation(
                ImageUtil.load("images/player/MB-69/player1.png"),
                ImageUtil.load("images/player/MB-69/player2.png"),
                ImageUtil.load("images/player/MB-69/player3.png"),
                ImageUtil.load("images/player/MB-69/player4.png"));
        this.playerMove  = new PlayerMove();
        this.boxCollider = new BoxCollider(x,y,40,20);
    }
    //method


    @Override
    public void run() {
        super.run();
        this.move();
        this.shoot();
        this.hitEnemies();

    }

    public void shoot() {
        playerShoot.run(this);
    }

    private void hitEnemies(){
        Enemy enemy = GameOject.checkCollision(this.boxCollider, Enemy.class);
        if(enemy != null){
            System.out.println("Hit!");
            enemy.getHitEnemies();
            this.destroy();
        }
    }


    public  void move() {
        this.playerMove.run(this.position);
    }

    public void getStop() {
        this.stopgame();
    }

    public void getHit() {
        this.getStop();
    }
}