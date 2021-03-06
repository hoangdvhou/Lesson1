package game;

import bloods.SpawnBloods;
import enemies.Enemy;
import players.Player;
import bases.GameOject;
import enemies.SpawnEnemy;
import inputs.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    ArrayList<GameOject> gameOjects = new ArrayList<>();
    InputManager inputManager;
    BufferedImage backBuffer;//null
    Graphics backBufferGraphics;
    GameOject spawnEnemys;
    SpawnBloods spawnBloods;
    GameOject background;

    public GameCanvas() {
        background = new Background(300,400);
        spawnEnemys = new SpawnEnemy(30,100);
        spawnBloods = new SpawnBloods(20,100);
        inputManager = InputManager.instance;
       // inputManager = new inputs.InputManager();

        // enemies.Enemy
        Player player = new Player(300,700);

        GameOject.add(background);
        GameOject.add(player);
        GameOject.add(new Enemy(0,0));
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
        //backBufferGraphics.drawImapge(player.image, player.x, player.y, null);
        GameOject.renderALL(backBufferGraphics);
        this.repaint();
    }
}

