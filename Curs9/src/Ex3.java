import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Ex3 {

    public static void main(String[] args){
        Type type = Type.PUBLISH_ON;
        //Type type = Type.SUBSCRIBE_ON;
        switch (type){
            case PUBLISH_ON:
                System.out.println("#### usign publishOn");
                publishOn();
                break;
            case SUBSCRIBE_ON:
                System.out.println("#### using subscrieOn");
                SUBSCRIBE_ON();
        }
    }

    private static enum Type{
        PUBLISH_ON, SUBSCRIBE_ON
    }

    private static void publishOn(){

        Scheduler s2 = Schedulers.newParallel("t2", 4);
        Scheduler s3 = Schedulers.newParallel("t3", 4);

        final Flux<String> flux = Flux.range(1,2)
                .map( i ->{
                    System.out.println("map1 "  +Thread.currentThread().getName());
                    return 10 + i;
                })
                .publishOn(s2)
                .map(i -> {
                    System.out.println("map2 " + Thread.currentThread().getName());
                    return "value "+ i;
                })
                .publishOn(s3)
                .map(i -> {
                    System.out.println("map3 " + Thread.currentThread().getName());
                    return "value "+ i;
                });
        new Thread(()-> flux.subscribe(System.out::println), "t1").start();
    }

    private static void subscribeOn(){
        Scheduler s = Schedulers.newParallel("t2", 4);
        final Flux<String> flux = Flux.range(1, 2)
                .map(i -> {
                    System.out.println("map1 " + Thread.currentThread().getName());
                    return 10 + i;
                })
                .subscribeOn(s)
                .map(i ->{
                    System.out.println("map2 "  +Thread.currentThread().getName());
                    return "value "+ i;
                });
        new Thread(()-> flux.subscribe(System.out::println), "t1").start();
    }
}
