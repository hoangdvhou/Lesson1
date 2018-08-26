import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JPanel {
    Vector2D position;

    Image image;
    InputManager inputManager;
    int count;
    boolean shootLock = false;
    ArrayList bullets;

    Player(int x,int y){
        this.position = new Vector2D(x,y);
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }
    //method

    void render(Graphics g) {
        g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
    }

    void run() {
        this.move();
        this.fire();

    }

    void fire() {
        if(inputManager.xPressed && !shootLock){
            PlayerBullet newBullet = new PlayerBullet((int)this.position.x, (int)this.position.y);
            bullets.add(newBullet);
            this.shootLock = true;

        }

    }

    void move() {
        Vector2D velocity = new Vector2D();
        if (inputManager.rightPressed) {

            velocity.x +=5;
        }
        if (inputManager.leftPressed) {
            velocity.x -=5;
        }
        if (inputManager.downPressed) {
            velocity.y +=5;
        }
        if (inputManager.upPressed) {
            velocity.y -=5;
        }
        this.position.addUp(velocity);


    }
        //void shoot(ArrayList<PlayerBullet> bullets) {
        //if (inputManager.xPressed && !shootLock) {
         //   PlayerBullet newB = new PlayerBullet(this.x,this.y);
         //   newB.x = x;
         //   newB.y = y;
          //  bullets.add(newB);
          //  shootLock = true;
        }
        //if(shootLock) {
          //  count++;
            //if (count > 30){
              //  shootLock = false;
               // count = 0;
            //}
        //}
        //}
    //}
