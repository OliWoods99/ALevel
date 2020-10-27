package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class Main extends Application {

    public static Canvas canvas = new Canvas(800, 600);
    public static Circle circle = new Circle(775, 300, 12, Color.DARKRED);


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent start = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("Ball Game");
        primaryStage.setScene(new Scene(start, 300, 275));
        primaryStage.show();
    }
    public static void main (String[]args){
        launch(args);
    }
}
