package players;
import bases.BoxCollider;
import bases.GameOject;
import bases.ImageRenderer;

import java.util.ArrayList;

public class Player extends GameOject {
    PlayerMove playerMove;
    public ArrayList bullets;//shoot
    PlayerShoot playerShoot;
    PlayerBullet playerBullet;

    public Player(int x,int y){
        super(x,y);
        playerShoot = new PlayerShoot();
        imageRenderer = new ImageRenderer("images/player/MB-69/player2.png");
        this.playerMove  = new PlayerMove();
        this.boxCollider = new BoxCollider(x,y,40,20);
        playerBullet = new PlayerBullet((int)this.position.x,(int)this.position.y);
    }
    //method


    @Override
    public void run() {
        super.run();
        this.move();
        this.shoot();
        playerBullet.hitEnemies();

    }

    public void shoot() {
        playerShoot.run(this);
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