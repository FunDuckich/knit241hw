package org.knit.solutions.lab4sem2;

public class TvOnCommand implements Command {
    private final Tv tv;
    private int previousChannel;
    private boolean wasOn;

    public TvOnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.wasOn = tv.isOn();
        this.previousChannel = tv.getChannel();
        tv.on();
        if (!wasOn) {
            tv.setChannel(1);
        } else {
            System.out.println(tv.getLocation() + " телевизор уже был включен, канал " + tv.getChannel());
        }
    }

    @Override
    public void undo() {
        if (!wasOn) {
            tv.off();
        } else {

            tv.on();
            tv.setChannel(previousChannel);
            System.out.println(tv.getLocation() + " телевизор (отмена TvOnCommand) возвращен на канал " + previousChannel);
        }
    }
}
