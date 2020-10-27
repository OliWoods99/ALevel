package sample;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.Random;
public class Ball{
    double posX = 0;
    double posY = BallNote();
    double speed = BallSpeed();
    Color ballColor = Color.BLACK;
    private int RandomMaker(int z){
        Random rand = new Random();
        int x = rand.nextInt(z);
        return x;
    }
    public void move(){
        posX = posX + 1 * speed;
    }
    public boolean collisionCheck(Circle circle){
        Bounds bounds = circle.getLayoutBounds();
        return (bounds.contains(posX,posY));
    }
    private double BallNote() {
        switch (RandomMaker(12)) {
            case 0:
                //D5
                posY = 210;
                break;
            case 1:
                //C5
                posY = 250;
                break;
            case 2:
                //B4
                posY = 290;
                break;
            case 3:
                //A4
                posY = 330;
                break;
            case 4:
                //G4
                posY = 370;
                break;
            case 5:
                //F4
                posY = 410;
                break;
            case 6:
                //E4
                posY = 450;
                break;
            case 7:
                //E5
                posY = 170;
                break;
            case 8:
                //F5
                posY = 130;
                break;
            case 9:
                //G5
                posY = 90;
                break;
            case 10:
                //C4
                posY = 530;
                break;
            case 11:
                //D4
                posY = 490;
                break;

        }
        return posY;
    }
    private double BallSpeed(){
        switch (RandomMaker(3)){
            case 0:
                speed = 0.5;
                break;
            case 1:
                speed = 0.75;
                break;
            case 2:
                speed = 1;
                break;
            default:
                speed = 1.5;
                break;
        }
        return speed;
    }
}
