import java.util.ArrayList;
import java.util.List;

public class Main {

    public static long v = 0;
    public static void main(String[] args) throws InterruptedException{
        int nrOfThreads = 5000;
        List<MyThread> threads = new ArrayList<>();
        for(int i = 0; i < nrOfThreads; i++){
            threads.add(new MyThread());
        }

        for(MyThread thread: threads){
            thread.start();
        }

        for(MyThread thread: threads){
            thread.join();
        }

        System.out.print(v);

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            increment();
        }

        static synchronized void increment(){
            for(int i = 0; i < 1_000_000; i++){
                v++;
            }
        }
    }
}
