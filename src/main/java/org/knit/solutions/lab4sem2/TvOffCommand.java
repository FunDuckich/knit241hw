package org.knit.solutions.lab4sem2;

public class TvOffCommand implements Command {
    private final Tv tv;
    private int previousChannel;
    private boolean wasOnActually;

    public TvOffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.wasOnActually = tv.isOn();
        if (this.wasOnActually) {
            this.previousChannel = tv.getChannel();
            tv.off();
        } else {
            System.out.println(tv.getLocation() + " телевизор уже был выключен.");
        }
    }

    @Override
    public void undo() {
        if (wasOnActually) {
            tv.on();
            tv.setChannel(previousChannel);
        } else {
            System.out.println(tv.getLocation() + " телевизор не был выключен этой командой, отмена не требуется.");
        }
    }
}
