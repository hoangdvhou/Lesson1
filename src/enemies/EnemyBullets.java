package enemies;

import bases.GameOject;
import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;

public class EnemyBullets extends GameOject {

    public EnemyBullets(int x, int y){
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0,5);

    }
}


