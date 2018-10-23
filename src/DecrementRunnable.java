/**
 * An decrementer runnable which decrements a Counter.
 *
 * @author Chris Brown
 */
public class DecrementRunnable implements Runnable {
    private static final int DELAY = 1;
    private Counter counter;

    /**
     * Constructs a top-up runnable.
     * @param c the counter to be incremented
     */
    public DecrementRunnable(Counter c) {
        this.counter = c;
    }

    @Override
    public void run() {
        try {
            counter.dec();
            Thread.sleep(DELAY);
        }
        catch (InterruptedException exception) {
           exception.printStackTrace();
        }
    }
}
