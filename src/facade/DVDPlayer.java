package facade;

public class DVDPlayer {

    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("DVDPlayer on");
    }

    public void off() {
        System.out.println("DVDPlayer off");
    }

    public void play() {
        System.out.println("DVDPlayer play");
    }

    public void pause() {
        System.out.println("DVDPlayer pause");
    }
}
