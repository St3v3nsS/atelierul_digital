import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex7 {

    public static void main(String[] args) throws Exception{
        final BankAccount momAccount = new BankAccount("mom", 100_000D);
        final BankAccount myAccount = new BankAccount("me", 100D);

        Transaction t1 = new Transaction("T1", momAccount, myAccount, 15D);
        Transaction t2 =  new Transaction("T2", myAccount, momAccount, 100D);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(momAccount);
        System.out.println(myAccount);
    }

    static class Transaction extends Thread{
        private String name;
        private BankAccount from;
        private BankAccount to;
        private Double amount;


        public Transaction(String name, BankAccount from, BankAccount to, Double amount){
            this.name = name;
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public void run() {
            BankAccount.transfer(from, to, amount);
        }
    }

    static class BankAccount {
        private String name;
        private Double debit;

        public BankAccount(String name, Double debit){
            this.name = name;
            this.debit = debit;
        }

        private Lock lock = new ReentrantLock();

        static void transfer(BankAccount from, BankAccount to, Double amount){

            System.out.println("Gimme the to!");
            synchronized (from){
                from.withdraw(amount);
                synchronized (to){
                    to.deposit(amount);
                }
            }

        }

        void withdraw(Double amount){
            longDatabaseCall();

            if( debit - amount >= 0){
                debit -= amount;
            }


        }

        void deposit(Double amount){
            debit += amount;
            longDatabaseCall();

        }

        void longDatabaseCall() {
            try{
                System.out.println("Getting from DB");
                Thread.sleep(800);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        @Override
        public String toString() {
            return name + ' ' + debit;
        }
    }
}


