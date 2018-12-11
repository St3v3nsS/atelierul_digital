
public class Ex8 {

    public static void main(String[] args) throws Exception{
        final BankAccount momAccount = new BankAccount("mom", 100_000D);
        final BankAccount myAccount = new BankAccount("me", 1001D);

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
        private boolean status = true;

        public BankAccount(String name, Double debit){
            this.name = name;
            this.debit = debit;
        }

        static void transfer(BankAccount from, BankAccount to, Double amount){

            System.out.println("Gimme the to!");
            synchronized (amount){
                while(true) {
                    if(to.status){
                        to.deposit(amount);
                        from.status = true;
                        to.status = false;
                    }


                    if(from.status){
                        from.withdraw(amount);
                        to.status = true;
                        from.status = false;
                    }
                }

            }

        }

        boolean withdraw(Double amount){
            longDatabaseCall();

            if( debit - amount >= 0){
                debit -= amount;
                return true;
            }

            return false;
        }

        boolean deposit(Double amount){
            debit += amount;
            longDatabaseCall();
            return true;
        }

        void longDatabaseCall() {
            try{
                System.out.println(this.name + " Getting from DB");
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


