import java.util.Random;

public class Ex9 {

    public static void main(String[] args){
        Monitor m = new Monitor();
        m.initialization_code();

        // create random threads for philosophers

        int cnt = 0;
        int val = 10;
        while(val != -1){
            (new Philosopher(m, cnt)).start();
            Random rand = new Random();
            cnt = rand.nextInt(5);
            val--;
        }


    }

    static class Philosopher extends Thread{
        private Monitor monitor;
        private int number;

        public Philosopher(Monitor monitor, int i){
            this.monitor = monitor;
            number = i;

        }

        @Override
        public void run() {
            //System.out.println(number + " " + monitor.getState(number));
            // Check if the philosopher i is Eating
            if(!monitor.getState(number).equals(states.EATING))
            {   //if not, try to eat
                monitor.pickup(number);
                // put down the chopsticks
                monitor.putdown(number);
            }
        }




    }

    static class Monitor {
        private states[] state;


        public void initialization_code(){
            state = new states[5];

            for(int i = 0; i < 5; i++){
                state[i] = states.THINKING;
            }
        }

        synchronized void pickup(int i){
            state[i] = states.HUNGRY;
            test(i);// check for available chopsticks
            while (!state[i].equals(states.EATING)) callWaitMethod(); //wait until it finds
        }

        synchronized void test(int i){
            if( !state[(i + 4) % 5].equals(states.EATING) && // check the left neighbour
                !state[(i + 1) % 5].equals(states.EATING) && // check the right one
                state[i].equals(states.HUNGRY)){  // and your are hungry
                state[i] = states.EATING;    // eat
                System.out.println("EATING " + i);
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                notify();   // signal yourself that you are not hungry anymore
            }
        }

        synchronized void putdown(int i){
            state[i] = states.THINKING; // done eating, start thinking
            System.out.println("Done EATING " + i + " neighbours: " + (i + 4) % 5 + " " +(i + 1) % 5 + " with states: " + state[(i + 4) % 5] + " " + state[(i + 1) % 5]);
            test((i+4)%5);  // test the neighbours
            test((i+1)%5);
        }

        public void callWaitMethod(){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public states getState(int i) {
            return state[i];
        }
    }
}
