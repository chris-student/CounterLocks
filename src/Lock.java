/**
 * Simple lock implementation from Jenkov tutorials:
 * http://tutorials.jenkov.com/java-concurrency/locks.html
 *
 * See the link for information on how to make lock reentrant if necessary.
 */
public class Lock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                    + "entering into wait.");
            wait();
        }
        isLocked = true;
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                + " - successful lock");
    }

    public synchronized void unlock() {
        isLocked = false;
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                + " - successful unlock");
        notify();
    }
}