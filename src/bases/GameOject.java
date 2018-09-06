package bases;

import java.awt.*;
import java.util.ArrayList;

public class GameOject {
    public Vector2D position;
    public ImageRenderer imageRenderer;

    private static ArrayList<GameOject> gameOjects = new ArrayList<>();
    private static ArrayList<GameOject> newGameOjects = new ArrayList<>();
    public static void add(GameOject g) {
        newGameOjects.add(g);
    }
    public static void runAll() {
        for(GameOject go : gameOjects){
            go.run();
        }

        gameOjects.addAll(newGameOjects);
        newGameOjects.clear();
    }
    public static void renderALL(Graphics g) {
        for (GameOject go : gameOjects){
            go.render(g);
        }
    }

    public GameOject(int x,int y) {
        this.position = new Vector2D(x,y);
        this.imageRenderer = null; //not yet specified
    }
    public void run() {

    }
    public void render(Graphics g) {
        if(imageRenderer != null) {
            this.imageRenderer.render(g,this.position);
        }
    }
}
