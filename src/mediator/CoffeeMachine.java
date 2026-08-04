package mediator;

public class CoffeeMachine extends Colleague {

    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startCoffee() {
        System.out.println("Coffee Machine: Starting coffee...");
    }

    public void finishCoffee() {
        System.out.println("Coffee Machine: Finishing coffee...");
        sendMessage(0);
    }
}
