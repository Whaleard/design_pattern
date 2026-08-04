package mediator;

public class TV extends Colleague {

    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startTV() {
        System.out.println("TV: Start TV...");
    }

    public void stopTV() {
        System.out.println("TV: Stop TV...");
    }
}
