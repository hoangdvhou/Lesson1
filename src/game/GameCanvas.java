package game;

import Players.Player;
import Players.PlayerBullet;
import bases.ImageUtil;
import enemies.Enemy;
import enemies.EnemyBullets;
import inputs.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;
    Player player;
    ArrayList<PlayerBullet> bullets;
    ArrayList<EnemyBullets> enemiesbullets;
    ArrayList<Enemy> enemies;
    InputManager inputManager;
    BufferedImage backBuffer;//null
    Graphics backBufferGraphics;
    Random random;
    int count;

    public GameCanvas() {


        inputManager = InputManager.instance;
       // inputManager = new inputs.InputManager();


        random = new Random();
        bullets = new ArrayList<>();


        // enemies.Enemy
        enemies = new ArrayList<>();

        Enemy e1 = new Enemy(100,50);


        player = new Player(268,680);
        player.bullets = this.bullets;
        background = ImageUtil.load("images/background/background.png");
        //
        enemies.add(e1);

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
        InputManager.instance = inputManager; // refer
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }




    void run() {
        player.run();

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
            for (EnemyBullets eb : e.bullets) {
                eb.run();
            }
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
            for(EnemyBullets bE:e.bullets){
                bE.render(backBufferGraphics);
            e.render(backBufferGraphics);
            }
        }
        this.repaint();
    }
}

