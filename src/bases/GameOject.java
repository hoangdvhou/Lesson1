package bases;

import enemies.Enemy;
import players.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameOject {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    public boolean isActive;
    public boolean isStop = true;

    private static ArrayList<GameOject> gameOjects = new ArrayList<>();
    private static ArrayList<GameOject> newGameOjects = new ArrayList<>();

    public static void add(GameOject g) {
        newGameOjects.add(g);
    }

    public static void runAll() {
        for (GameOject go : gameOjects) {
            if(go.isActive && !go.isStop)
            go.run();
        }

        gameOjects.addAll(newGameOjects);
        newGameOjects.clear();
    }

    public static void renderALL(Graphics g) {
        for (GameOject go : gameOjects) {
            if (go.isActive&& !go.isStop)
            go.render(g);
        }
    }

    public static Enemy checkCollision(BoxCollider boxCollider) {
        Enemy result = null;
        for (GameOject go : gameOjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go instanceof Enemy) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result = (Enemy) go;
                    }
                }
            }
        }

        return result;
    }
    public static Player checkCollision2(BoxCollider boxCollider){
        Player result2 = null;
        for (GameOject go : gameOjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go instanceof Player) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result2 = (Player) go;
                    }
                }
            }
        }

        return result2;
    }
    public BoxCollider boxCollider;

    public GameOject(int x, int y) {
        this.position = new Vector2D(x, y);
        this.imageRenderer = null; //not yet specified
        this.boxCollider = null;
        this.isActive = true;
        this.isStop = false;
    }


    public void run() {
        if (this.boxCollider != null) {
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
            this.boxCollider.run();
        }
    }

    public void render(Graphics g) {
        if (imageRenderer != null) {
            this.imageRenderer.render(g, this.position);
        }
        if (this.boxCollider != null) {
            this.boxCollider.render(g);
        }
    }
    public void destroy(){
        this.isActive = false;
    }

    protected void stopgame() {
        this.isStop = false;
        System.out.println("You can play it again");
        this.position = null;
    }
}
