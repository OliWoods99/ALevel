package sample;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
public class MidiReceiver implements Receiver {

    public String name;
    public MidiReceiver(String name) {
        this.name = name;
    }
    public void send(MidiMessage msg, long timeStamp) {
        System.out.println("midi received");
        System.out.println(Translator.getMidiMSG(msg.getMessage()));
    }
    public void close() {}
}