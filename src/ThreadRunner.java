public class ThreadRunner {

    public static void main(String[] args) {
        Counter c = new Counter();

        IncrementRunnable inc = new IncrementRunnable(c);
        DecrementRunnable dec = new DecrementRunnable(c);

        Thread incT1 = new Thread(inc);
        //Thread incT2 = new Thread(inc);
        Thread decT1 = new Thread(dec);

        incT1.start();
//        try {
//            topUpT.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        incT2.start();
        decT1.start();
    }
}
