package bloods;

import bases.FrameCounter;
import bases.GameOject;
import bases.Vector2D;

import java.util.Random;

public class SpawnBloods extends GameOject {
    Random random;
    FrameCounter frameCounter;

    public SpawnBloods(int x, int y) {
        super(x, y);
        this.position = new Vector2D(x, y);
        random = new Random();
        this.frameCounter = new bases.FrameCounter(150);
    }

    @Override
    public void run() {
        super.run();
        frameCounter.run();
        if(frameCounter.expried) {
            frameCounter.reset();
            int posX = random.nextInt(600);
            Bloods bloods = new Bloods(posX, 0);
            GameOject.add(bloods);
        }

    }

}


