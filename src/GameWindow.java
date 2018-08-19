import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    //InputManager inputManager;


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
                System.out.println("KeyPressed");
                gameCanvas.inputManager.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameCanvas.inputManager.KeyReleased(e);
            }
        });
        this.setSize(600, 800);
        this.setResizable(false);
        this.setTitle("Micro-war");
        this.setLocationRelativeTo(null);

        //Setup canvas
        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);


        this.setVisible(true);
    }



    void mainLoop() {
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

