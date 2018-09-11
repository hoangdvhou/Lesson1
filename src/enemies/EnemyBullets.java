package enemies;

import bases.*;
import players.Player;

public class EnemyBullets extends GameOject {

    public EnemyBullets(int x, int y){
        super(x,y);
        this.renderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
        this.boxCollider = new BoxCollider(x,y,20,30);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0,5);
        this.hitPlayer();

    }
    public void hitPlayer(){
        Player player = GameOject.checkCollision(boxCollider,Player.class);
        if (player != null) {
            System.out.println("Hit");
            player.getHit();
            this.destroy();
        }

    }
}


