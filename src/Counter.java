public class Counter {

    private Lock lock = new Lock();
    private volatile int count = 0;

    public int inc() throws InterruptedException {
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                + "attempting to lock Counter (count: " + count + ")");
        lock.lock();
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                + "incrementing " + count);
        int newCount = ++count;
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                + "attempting to unlock Counter (count: " + count + ")");
        lock.unlock();
        return newCount;
    }

    public int dec() throws InterruptedException {
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                + "attempting to lock Counter (count: " + count + ")");
        lock.lock();
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                    + "decrementing " + count);
        int newCount = --count;
        System.out.println("Thread with id " + Thread.currentThread().getId() + ", "
                + "attempting to unlock Counter (count: " + count + ")");
        lock.unlock();
        return newCount;
    }

    public int getCount() {
        return count;
    }
}