import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;


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
                gameCanvas.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameCanvas.KeyReleased(e);
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

    long lastTimeRender = 0;

    void mainLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                gameCanvas.update();
                gameCanvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}

