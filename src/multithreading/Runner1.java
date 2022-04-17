package multithreading;

import lombok.Setter;

@Setter
public class Runner1 extends Thread{

    private volatile boolean done;

    public Runner1 (final boolean done) {
        this.done = done;
    }

    @Override
    public void run () {

        while (!done) {
            System.out.println("Runner 1");
        }

    }

    public void shutDown(final boolean done) {

        this.done = done;
    }

}
