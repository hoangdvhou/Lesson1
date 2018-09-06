package enemies;

import bases.GameOject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.util.ArrayList;
import java.util.Random;

public class SpawnEnemys extends GameOject {
    Random random;

    public SpawnEnemys(int x, int y) {
        super(x, y);
        this.position = new Vector2D(x,y);
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        enemySpawnCount++;
        if(enemySpawnCount >= 60) {
            enemySpawnCount = 0;
            int posX = random.nextInt(600);
            Enemy enemy = new Enemy(posX,0);
            GameOject.add(enemy);
        }
    }
    int enemySpawnCount;
}

