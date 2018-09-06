package Bloods;

import bases.GameOject;
import bases.Vector2D;
import enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class SpawnBloods  {
    Random random;

    public SpawnBloods() {
        random = new Random();
    }

    public void run() {
        bloodsSpawnCount++;
        if (bloodsSpawnCount >= 60) {
            bloodsSpawnCount = 0;
            int posX = random.nextInt(600);
            Bloods bloods = new Bloods(posX, 0);
            GameOject.add(bloods);
        }

    }
    int bloodsSpawnCount;

}


