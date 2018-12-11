import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex9 {

    public static void main(String[] args){

        Philosopher[] philosophers = new Philosopher[5];
        Chopstick[] chopsticks = new Chopstick[5];

        for(int i = 0; i < 5; i++){
            chopsticks[i] = new Chopstick(i);
        }

        for(int i = 0; i < 5; i++){
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i+1)%5]);
            philosophers[i].start();
        }

    }

    static class Philosopher  extends Thread {
        private int id;
        private Chopstick left;
        private Chopstick right;

        private Random random = new Random();
        private int randTime;

        public Philosopher(int id, Chopstick left, Chopstick right){
            this.id = id;
            this.randTime = random.nextInt(30);
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            try{
                while(true){
                    think();

                    if(left.pickUp(this, "left")){
                        if(right.pickUp(this, "right")){

                            eat();
                            right.putDown(this, "right");

                        }
                        left.putDown(this, "left");

                    }


                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        private void think() throws InterruptedException{
            System.out.println(this + " IS THINKING");
            Thread.sleep(random.nextInt(randTime * 1000));
        }

        private void eat() throws InterruptedException {
            System.out.println(this + " IS EATING");
            Thread.sleep(random.nextInt(randTime * 1000));
        }

        @Override
        public String toString() {
            return "P" + id;
        }
    }

    static class Chopstick {
        private int id;

        Lock lock = new ReentrantLock(true);

        public Chopstick(int id){
            this.id = id;
        }

        public boolean pickUp(Philosopher who, String where){
            if(lock.tryLock()){
                //lock.lock();
                //System.out.println(who + " picked up fork " + where + " " + this);
                return true;
            }
            return false;
        }

        public void putDown(Philosopher who, String where){
            lock.unlock();
            //System.out.println(who + " putted down fork "  + where + " " + this);
        }

        @Override
        public String toString() {
            return "C" + id;
        }
    }
}
