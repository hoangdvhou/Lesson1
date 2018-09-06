package Players;
import bases.GameOject;
import bases.ImageRenderer;
import bases.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends GameOject {
    PlayerMove playerMove;
    public ArrayList bullets;//shoot
    PlayerShoot playerShoot;

    public Player(int x,int y){
        super(x,y);
        playerShoot = new PlayerShoot();
        imageRenderer = new ImageRenderer("images/player/MB-69/player2.png");
        this.playerMove  = new PlayerMove();
    }
    //method


    @Override
    public void run() {
        super.run();
        this.move();
        this.shoot();
    }

    public void shoot() {
        playerShoot.run(this);
    }


    public  void move() {
        this.playerMove.run(this.position);
    }
        }