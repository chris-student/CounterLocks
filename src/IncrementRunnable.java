/**
 * An incrementer runnable which increments a Counter.
 *
 * @author Chris Brown
 */
public class IncrementRunnable implements Runnable {
    private static final int DELAY = 1;
    private Counter counter;

    /**
     * Constructs a top-up runnable.
     * @param c the counter to be incremented
     */
    public IncrementRunnable(Counter c) {
        this.counter = c;
    }

    @Override
    public void run() {
        try {
            counter.inc();
            Thread.sleep(DELAY);
        }
        catch (InterruptedException exception) {
           exception.printStackTrace();
        }
    }
}
