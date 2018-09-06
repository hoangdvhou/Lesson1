package Players;

import bases.GameOject;
import bases.ImageRenderer;
import bases.Vector2D;
import bases.ImageUtil;
import java.awt.*;

public class PlayerBullet extends GameOject {
    public PlayerBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");

    }

    public void run() {
        super.run();
        this.position.addUp(0,-10);

    }
}
