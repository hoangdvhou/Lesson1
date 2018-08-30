package Players;

import bases.FrameCounter;
import inputs.InputManager;

public class PlayerShoot {
    boolean shootLock ;//shoot
    FrameCounter frameCounter = new FrameCounter(30);
    void run(Player player) {
        if (InputManager.instance.xPressed && !shootLock) {
            PlayerBullet newBullet = new PlayerBullet((int) player.position.x, (int) player.position.y);
            player.bullets.add(newBullet);
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

