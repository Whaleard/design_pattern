package command;

public class LightOffCommand implements Command {

    /**
     * 聚合LightReceiver
     */
    LightReceiver receiver;

    public LightOffCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 调用接收者的方法
        receiver.off();
    }

    @Override
    public void undo() {
        // 调用接收者的方法
        receiver.on();
    }
}
