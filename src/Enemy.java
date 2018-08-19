import javax.swing.*;
import java.awt.*;

public class Enemy extends JPanel {
    int x;
    int y;
    Image image;

    Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        image = ImageUtil.load("images/enemy/bacteria/bacteria1.png"); }

    //Method
        void render(Graphics g){
        g.drawImage(this.image,this.x,this.y,null);


        }
        void run() {
            this.y += 5 ;
        }
    }

