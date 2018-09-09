package enemies;

import bases.*;
import players.Player;

import javax.swing.*;
import java.awt.*;

public class EnemyBullets extends GameOject {

    public EnemyBullets(int x, int y){
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
        this.boxCollider = new BoxCollider(x,y,20,30);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0,5);
        this.hitPlayer();

    }
    private void hitPlayer(){
        Player player = GameOject.checkCollision2(boxCollider);
        if (player != null) {
            System.out.println("Hit");
            player.getHit();
            this.destroy();
        }

    }
}


