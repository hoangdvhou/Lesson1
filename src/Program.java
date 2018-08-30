import bases.Vector2D;
import game.GameWindow;
//import game.Setting;

public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.mainLoop();
        Vector2D vector2D;

        vector2D = new Vector2D(5,7);
        vector2D.addUp(2,3);

        Vector2D v3 = vector2D.add(3,4);
        vector2D.print();
        //Setting.instance.SetSize();

    }

}
