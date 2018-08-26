import javax.swing.*;
import java.awt.*;

public class Enemy extends JPanel {
    int x;
    int y;
    Image image;
    Vector2D position;

    Enemy(int x, int y) {
        this.position = new Vector2D(x, y);
        image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

    //Method
    void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);


    }

    void run() {
        this.move();
    }

    private void move() {
        Vector2D velocity = new Vector2D();
        velocity.y += 5;
        this.position.addUp(velocity);
    }
}

