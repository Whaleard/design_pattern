package command;

public class LightOnCommand implements Command {

    /**
     * 聚合LightReceiver
     */
    LightReceiver receiver;

    public LightOnCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 调用接收者的方法
        receiver.on();
    }

    @Override
    public void undo() {
        // 调用接收者的方法
        receiver.off();
    }
}
