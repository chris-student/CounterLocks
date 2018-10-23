import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    Counter c;
    IncrementRunnable inc;
    DecrementRunnable dec;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        c = new Counter();

        inc = new IncrementRunnable(c);
        dec = new DecrementRunnable(c);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void inc() {
    }

    @org.junit.jupiter.api.Test
    void dec() {
    }

    @org.junit.jupiter.api.Test
    void getCount() {
    }

    /**
     * 1. Two account holders trying to check balance simultaneously.
     */
    @org.junit.jupiter.api.Test
    void simultaneousBalanceCheck() {
        assertEquals(0, c.getCount());
    }

    /**
     * 2. One account holder tries to check the balance while the other is
     *    depositing/withdrawing money.
     */
    @org.junit.jupiter.api.Test
    void balanceCheckWhileDepositing() {
        Thread incT = new Thread(inc);
        incT.start();
        // Check the balance ASAP.
        assertEquals(0, c.getCount());
        try {
            incT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Wait until the thread is done then check it.
        assertEquals(1,c.getCount());
    }

    /**
     * 3. The two account holders are trying simultaneously to deposit/withdraw
     *    money & then check the balance.
     */
    @org.junit.jupiter.api.Test
    void simultaneousDepositAndWithdrawl() {
        // Start two threads, one which increments and one which decrements.
        Thread incT = new Thread(inc);
        Thread decT = new Thread(dec);
        incT.start();
        decT.start();
        // Allow time for threads to complete.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Verify that balance is as expected afterwards.
        assertEquals(0, c.getCount());
    }

    /*

    4. Same as 3, but at the same time a bank employee is in the process of
       completing a standing order in/out the account.

    5. There are insufficient funds to complete a withdraw. This is an open-
       ended scenario and it is up to you to decide what the expected behaviour
       will be. Ideally (i.e. in order to achieve full marks), your system
       should implement a mechanism that waits for the balance to grow.

    6. Two bank employees are trying simultaneously to modify the details of a
       bank account.
     */
}