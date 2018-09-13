package bases;

import players.PlayerBullet;

import java.awt.*;
import java.util.ArrayList;

public class GameOject {
    public Vector2D position;
    public Renderer renderer;
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
        System.out.println(gameOjects.size());
    }

    public static void renderALL(Graphics g) {
        for (GameOject go : gameOjects) {
            if (go.isActive&& !go.isStop)
            go.render(g);
        }
    }
    //Generics
    public static <T extends GameOject> T checkCollision(BoxCollider boxCollider,Class<T>cls) {
        T result = null;
        for (GameOject go : gameOjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go.getClass().equals(cls)) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result = (T) go;
                    }
                }
            }
        }

        return result;
    }
    public BoxCollider boxCollider;

    public GameOject(int x, int y) {
        this.position = new Vector2D(x, y);
        this.renderer = null; //not yet specified
        this.boxCollider = null;
        this.isActive = true;
        this.isStop = false;
    }

    public static <T extends GameOject> PlayerBullet recycle(int x,int y,Class<T>cls) {
        T pb = null;
        for(GameOject go:gameOjects){
            if(!go.isActive){
                if(go.getClass().equals(cls)){
                    pb = (T) go;
                }
            }
        }

        if (pb == null){
            pb = (T)new PlayerBullet(x,y);
            GameOject.add(pb);
        }
        else {
            pb.isActive =true;
            pb.position.x = x;
            pb.position.y = y;
        }
        return (PlayerBullet) pb;
    }
    public void run() {
        if (this.boxCollider != null) {
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
            this.boxCollider.run();
        }
    }

    public void render(Graphics g) {
        if (renderer != null) {
            this.renderer.render(g, this.position);
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
        System.exit(0);
    }
}
