package bases;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Animation extends Renderer {
    private final boolean oneTime;
    ArrayList<Image> images;
    int imageIndex;
    FrameCounter frameCounter;
    public boolean finish;

    public Animation(Image... imgs){
        this(5,false, imgs);
    }


    //1.load anh
    public Animation(int framedeley,boolean oneTime,Image...imgs){
        this.images = new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));
        this.oneTime = oneTime;
        imageIndex = 0;
        frameCounter = new FrameCounter(framedeley);
        finish = false;
    }
    //2.ve anh
    public void  render(Graphics g,Vector2D position){
        this.renderCurrentImage(g,position);
        changeCurrentImage();
    }

    private void changeCurrentImage() {
        frameCounter.run();
        if (frameCounter.expried) {
            frameCounter.reset();
            if (this.imageIndex < this.images.size() - 1) {
                this.imageIndex += 1;
            } else {
                if (this.oneTime){
                    this.finish = true;
                }
                this.imageIndex = 0;
            }
        }
    }

    private void renderCurrentImage(Graphics g,Vector2D position){
        Image currentImage = images.get(this.imageIndex);
        int width = currentImage.getWidth(null);
        int height = currentImage.getHeight(null);
        g.drawImage(currentImage,
                (int)position.x-width/2,
                (int)position.y-height/2,
                null);
    }

}
