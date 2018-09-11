package players;

import bases.FrameCounter;
import bases.GameOject;
import bases.Vector2D;
import inputs.InputManager;

public class PlayerShoot {
    boolean shootLock ;//shoot
    FrameCounter frameCounter = new FrameCounter(30);
    void run(Player player) {
        if (InputManager.instance.xPressed && !shootLock) {
            Vector2D bulletpPosition = player.position.Sub(0,50);
            //1.Try to recycle
            PlayerBullet newBullet = GameOject.recycle((int)bulletpPosition
                    .x,(int)bulletpPosition.y,PlayerBullet.class);
            //2.If can't recycle fail, create new

            this.shootLock = true;

        }//shoot
        if (shootLock) {
            frameCounter.run();
            if (frameCounter.expried) {
                shootLock = false;
                frameCounter.reset();
            }

        }
    }
}

