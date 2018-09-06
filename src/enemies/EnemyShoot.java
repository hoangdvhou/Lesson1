package enemies;

import bases.FrameCounter;
import bases.GameOject;

public class EnemyShoot {
    boolean shootLock;
    FrameCounter frameCounter = new FrameCounter(1000);

    void run(Enemy enemy) {
        if(!this.shootLock){
            EnemyBullets newBullet = new EnemyBullets((int)enemy.position.x,(int)enemy.position.y);
            GameOject.add(newBullet);
            this.shootLock=true;
        }
        if(shootLock){
            frameCounter.run();
            if(frameCounter.expried){
                shootLock=false;
                frameCounter.reset();
            }
        }
    }
}
