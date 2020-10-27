package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
public class Game {

    GraphicsContext gc = Main.canvas.getGraphicsContext2D();
    private java.util.Timer timer;
    public int score;
    public int lives = 10;
    public int LoopCount = 0;
    Random rand = new Random();
    ArrayList<Ball> Balls = new ArrayList<Ball>();

    public static boolean Running = true;{
        timer = new Timer();
        timer.schedule(new gameLoop(), 0, 1000/60);
    }
    public class gameLoop extends java.util.TimerTask {
        public void run()
        {
            gameUpdate();
            gameRender(gc);
            if (!Running) {
                timer.cancel();
                //System.exit(0);
            }
        }
    }
    private void gameUpdate() {
        System.out.println("update");
        LoopCount ++;
        if (LoopCount > 800){
            LoopCount = 1;
        }
        System.out.println(LoopCount);
        int x = rand.nextInt(100);
        if (x == 50) {
            Ball ball = new Ball();
            Balls.add(ball);
        }
        for (int i = 0; i < Balls.size(); i++) {
            Balls.get(i).move();
            if(Balls.get(i).collisionCheck(Main.circle)) {
                System.out.println("!COLLISION!");
                Balls.get(i).ballColor = Color.TRANSPARENT;
                score++;
            }
            if (Balls.get(i).posX >= 800 && Balls.get(i).ballColor != Color.TRANSPARENT ){
                lives--;
                Balls.remove(Balls.get(i));

            }
            if(lives == 0){
                Running = false;
            }
        }
    }
    private void gameRender(GraphicsContext gc) {
        gc.clearRect(0,0,800,600);

        gc.strokeLine(0,140,800,140);
        gc.strokeLine(0,220,800,220);
        gc.strokeLine(0,300,800,300);
        gc.strokeLine(0,380,800,380);
        gc.strokeLine(0,460,800,460);

        gc.fillText("score: "+score,10,67);
        gc.fillText("lives: "+lives,100,67);

        for (int i = 0; i < Balls.size(); i++) {
            gc.setFill(Balls.get(i).ballColor);
            gc.fillOval((Balls.get(i).posX),(Balls.get(i).posY),20,20);
        }
    }
}
