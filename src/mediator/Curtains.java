package mediator;

public class Curtains extends Colleague {

    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {

    }

    public void upCurtains() {
        System.out.println("Curtains: Up curtains...");
    }
}
