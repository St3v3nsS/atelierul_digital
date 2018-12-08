public class Ex3 {
    public static void main(String[] args) {
        Channel c = new Channel();
        (new Consumer(c)).start();
        (new Producer(c)).start();


    }
    static class Producer extends Thread {
        //TODO put your implementation here

        private static Channel channel;

        public Producer(Channel c) {
            channel = c;
        }

        @Override
        synchronized public void run() {
            for (int i = 1; i <= 10; i++){
                System.out.println("Producer put: " + i);
                channel.put("hello" + i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            channel.put("DONE");
        }
    }

    static class Consumer extends Thread {
        //TODO put your implementation here

        private static Channel channel;

        public Consumer(Channel c) {
            channel = c;
        }

        @Override
        synchronized public void run() {
            for (String message = channel.take(); !message.equals("DONE"); message = channel.take()){
                System.out.println("Consumer got: " + message);
            }
        }
    }
    static class Channel {
        private String message; private boolean isChannelEmpty = true;
        synchronized public String take() {
            while (isChannelEmpty){ callWaitMethod();};
            isChannelEmpty = true;
            notifyAll();
            return message;
        }
        synchronized public void put(String message) {

            while(!isChannelEmpty){callWaitMethod();};
            isChannelEmpty = false;
            this.message = message;
            notifyAll();

        }
        private void callWaitMethod() { try { wait(); } catch (InterruptedException e) { e.printStackTrace(); } }
    }

}
