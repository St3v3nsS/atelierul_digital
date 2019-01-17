import java.util.stream.IntStream;

public class Ex2 {
    public static void main(String[] args){
        int factor = 2;
        IntStream s = IntStream.range(0,10)
                .map(e -> {
                    System.out.println("multiplying for: " + e);
                    return e*factor;
                })
                .filter(e -> e > 5);

        int first = s.findFirst().getAsInt();
        System.out.println("first: " + first);
    }
}
