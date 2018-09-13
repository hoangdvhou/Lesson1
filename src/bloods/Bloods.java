package bloods;

import bases.*;

import java.util.ArrayList;

public class Bloods extends GameOject {
    public ArrayList<Bloods> bloodCells;

    public Bloods(int x, int y) {
        super(x, y);
        bloodCells = new ArrayList<>();
        renderer = new Animation(ImageUtil.load("images/bloodcells/blood-cell1.png"),
                ImageUtil.load("images/bloodcells/blood-cell2.png"),
                ImageUtil.load("images/bloodcells/blood-cell3.png"),
                ImageUtil.load("images/bloodcells/blood-cell4.png"));
    }
    private void deactivateIfNeeded() {
        if(this.position.y < 0){
            this.isActive = false;
        }
    }

    public void run(){
        this.position.addUp(3, 3);
        deactivateIfNeeded();
    }
}