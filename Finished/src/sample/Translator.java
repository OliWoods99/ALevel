package sample;

public class Translator {
    public static int getMidiMSG(byte[] msg){
        byte note = 0;
        int keyboardPosY = 0;
        for (int i = 0; i < msg.length; i++) {
            note = msg[1];
        }
        switch (note){
            case 60:
                //"C4";
                keyboardPosY = 540;
                break;
            case 62:
                //"D4";
                keyboardPosY = 500;
                break;
            case 64:
                //"E4";
                keyboardPosY = 460;
                break;
            case 65:
                //"F4";
                keyboardPosY = 420;
                break;
            case 67:
                //"G4";
                keyboardPosY = 380;
                break;
            case 69:
                //"A4";
                keyboardPosY = 340;
                break;
            case 71:
                //"B4";
                keyboardPosY = 300;
                break;
            case 72:
                //"C5";
                keyboardPosY = 260;
                break;
            case 74:
                //"D5";
                keyboardPosY = 220;
                break;
            case 76:
                //"E5";
                keyboardPosY = 180;
                break;
            case 77:
                //"F5";
                keyboardPosY = 140;
                break;
            case 79:
                //"G5";
                keyboardPosY = 100;
                break;
        }
        Main.circle.setCenterY(keyboardPosY);
        return keyboardPosY;
    }
}