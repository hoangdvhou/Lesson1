package enemies;

import bases.FrameCounter;
import bases.GameOject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.util.ArrayList;
import java.util.Random;

public class SpawnEnemys extends GameOject {
    Random random;
    FrameCounter frameCounter;

    public SpawnEnemys(int x, int y) {
        super(x, y);
        this.position = new Vector2D(x,y);
        random = new Random();
        this.frameCounter = new FrameCounter(150);
    }

    @Override
    public void run() {
        super.run();
        frameCounter.run();
        if(frameCounter.expried) {
            enemySpawnCount = 0;
            frameCounter.reset();
            Enemy newEnemy = new Enemy(
                    random.nextInt(600),0);
            GameOject.add(newEnemy);


        }
    }
    int enemySpawnCount;
}

