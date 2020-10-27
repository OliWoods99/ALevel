package sample;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.sound.midi.*;
import java.util.List;

public class Controller {
    public void handleButtonclick() {
        Stage playStage = new Stage();
        playStage.setOnCloseRequest(Event::consume);
        Game.Running=true;
        System.out.println("Working");
        StackPane playLayout = new StackPane();
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event ->{
            playStage.close();
            Game.Running = false;
        });

        Group playGroup = new Group(Main.canvas, Main.circle,exitButton);
        playLayout.getChildren().addAll(playGroup);
        Scene scene = new Scene(playLayout, 800, 600);
        playStage.setScene(scene);
        playStage.show();
        new Game();

        //midistuff

        MidiDevice device;
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < infos.length; i++) {
            try {
                device = MidiSystem.getMidiDevice(infos[i]);
                System.out.println(infos[i]);
                List<Transmitter> transmitters = device.getTransmitters();
                for (int j = 0; j < transmitters.size(); j++) {
                    transmitters.get(j).setReceiver(
                            new MidiReceiver(device.getDeviceInfo().toString())
                    );
                }
                Transmitter trans = device.getTransmitter();
                trans.setReceiver(new     MidiReceiver(device.getDeviceInfo().toString()));
                device.open();
                System.out.println("midi device found = " + device.getDeviceInfo());

            } catch (MidiUnavailableException e) {
                System.out.println("No available midi devices");
            }
        }
    }
    public void exit(){
        System.exit(0);
    }
}
