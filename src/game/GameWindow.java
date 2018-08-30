package game;

import inputs.InputManager;
//import game.Setting;

import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    //inputs.InputManager inputManager;


    public GameWindow() {
        //Setup game window

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                InputManager.instance.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                InputManager.instance.KeyReleased(e);
            }
        });
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(600, 800);

        this.setTitle("Micro-war");
        //Setup canvas
        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);

        this.setVisible(true);


    }



    public void mainLoop() {
        long lastTimeRender = 0;
        long currentTime;
        while (true) {
            currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                gameCanvas.run();
                gameCanvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}

