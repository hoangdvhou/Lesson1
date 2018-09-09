package bloods;

import bases.GameOject;
import bases.Vector2D;

import java.util.Random;

public class SpawnBloods extends GameOject {
    Random random;

    public SpawnBloods(int x, int y) {
        super(x, y);
        this.position = new Vector2D(x, y);
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
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


