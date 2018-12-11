public class Ex6 {
    public static void main(String[] args){
        OnePersonKitchen onePersonKitchen = new OnePersonKitchen();
        Person person1 = new Person("P1", onePersonKitchen);
        Person person2 = new Person("P2", onePersonKitchen);
        PersonThatNeverFinishesEating personThatNeverFinishesEating = new PersonThatNeverFinishesEating("P3", onePersonKitchen);
        person1.start();
        person2.start();
        personThatNeverFinishesEating.start();
    }

    public static void rest(){
        try{
            Thread.sleep(1_000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    static class OnePersonKitchen{}

    static class Person extends Thread{
        private OnePersonKitchen onePersonKitchen;
        private String id;
        public Person(String id, OnePersonKitchen onePersonKitchen){
            super(id);
            this.id = id;
            this.onePersonKitchen = onePersonKitchen;
        }

        @Override
        public void run() {
            while(true){
                synchronized (onePersonKitchen){
                    System.out.println(id + " finished eating");
                    rest();
                    onePersonKitchen.notifyAll(); // notify others that he finished eating
                    waitToBeNotifiedThatKithenIsOpen();
                }
            }
        }

        private void waitToBeNotifiedThatKithenIsOpen(){
            try{
                onePersonKitchen.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class PersonThatNeverFinishesEating extends Person{
        public PersonThatNeverFinishesEating(String id, OnePersonKitchen onePersonKitchen){
            super(id, onePersonKitchen);
        }

        @Override
        public void run() {
            synchronized (super.onePersonKitchen){
                while(true){
                    System.out.println(super.id + "eating ...");
                    rest();
                }
            }
        }
    }
}
