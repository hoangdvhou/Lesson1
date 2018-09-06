package game;

import Bloods.SpawnBloods;
import Players.Player;
import Players.PlayerBullet;
import bases.GameOject;
import bases.ImageUtil;
import enemies.Enemy;
import enemies.EnemyBullets;
import enemies.SpawnEnemys;
import inputs.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;
    ArrayList<GameOject> gameOjects = new ArrayList<>();
    InputManager inputManager;
    BufferedImage backBuffer;//null
    Graphics backBufferGraphics;
    GameOject spawnEnemys;
    SpawnBloods spawnBloods;

    public GameCanvas() {
        spawnEnemys = new SpawnEnemys(30,100);
        spawnBloods = new SpawnBloods();
        inputManager = InputManager.instance;
       // inputManager = new inputs.InputManager();

        // enemies.Enemy
        Player player = new Player(300,700);


        GameOject.add(player);
        background = ImageUtil.load("images/background/background.png");
        //
        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
        InputManager.instance = inputManager; // refer
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    };



    void run() {
        GameOject.runAll();
        spawnEnemys.run();
        spawnBloods.run();

        }

        int enemySpawnCount;
    void render() {
        backBufferGraphics.drawImage(background, 0, 0, null);
        //backBufferGraphics.drawImapge(player.image, player.x, player.y, null);
        GameOject.renderALL(backBufferGraphics);
        this.repaint();
    }
}

