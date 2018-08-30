package Players;
import bases.ImageRenderer;
import bases.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JPanel {
    Vector2D position;
    PlayerMove playerMove;
    ImageRenderer imageRenderer;
    public ArrayList bullets;//shoot
    PlayerShoot playerShoot;

    public Player(int x,int y){
        playerShoot = new PlayerShoot();
        this.position = new Vector2D(x,y);
        imageRenderer = new ImageRenderer("images/player/MB-69/player2.png");
        this.playerMove  = new PlayerMove();

    }
    //method



    public void run() {
        this.move();
        this.shoot();

    }

    public void shoot() {
        playerShoot.run(this);
    }

    public void render(Graphics g) {
        imageRenderer.render(g,this.position);

    }



    public  void move() {
        this.playerMove.run(this.position);


    }
        //void shoot(ArrayList<Players.PlayerBullet> bullets) {
        //if (inputManager.xPressed && !shootLock) {
         //   Players.PlayerBullet newB = new Players.PlayerBullet(this.x,this.y);
         //   newB.x = x;
         //   newB.y = y;
          //  bullets.add(newB);
          //  shootLock = true;
        }
        //
        //}
        //}
    //}
