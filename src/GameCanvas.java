import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class GameCanvas extends JPanel {
    Image background;
    Player player;
    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;


    InputManager inputManager;




    BufferedImage backBuffer;//null
    Graphics backBufferGraphics;
    Random random;
    int count;

    public GameCanvas() {



        inputManager = new InputManager();


        random = new Random();
        bullets = new ArrayList<>();


        // Enemy
        enemies = new ArrayList<>();

        Enemy e1 = new Enemy(100,50);

        Enemy e2 = new Enemy(200,50);


        Enemy e3 = new Enemy(300,50);


        Enemy e4 = new Enemy(400,50);


        Enemy e5 = new Enemy(500,50);


        Enemy e6 = new Enemy(600,50);


        player = new Player(268,680);
        player.bullets = this.bullets;
        background = ImageUtil.load("images/background/background.png");




        //
        enemies.add(e1);
        enemies.add(e2);
        enemies.add(e3);
        enemies.add(e4);
        enemies.add(e5);
        enemies.add(e6);


        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
        player.inputManager = inputManager; // refer
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }




    void run() {
        player.run();
        player.fire();
        for (PlayerBullet b : bullets) {
            b.run();
        }




        enemySpawnCount++;
        if(enemySpawnCount >= 60) {
            enemySpawnCount = 0;
            int posX = random.nextInt(600);
            Enemy enemy = new Enemy(posX, 0);
            enemies.add(enemy);
        }



        for (Enemy e : enemies) {
            e.run();
        }

        }
        int enemySpawnCount;



    void render() {
        backBufferGraphics.drawImage(background, 0, 0, null);
        //backBufferGraphics.drawImage(player.image, player.x, player.y, null);
        player.render(backBufferGraphics);
        for (PlayerBullet b: bullets) {
            b.render(backBufferGraphics);
        }
        for (Enemy e : enemies) {
            e.render(backBufferGraphics);

        }
        this.repaint();
    }
}

