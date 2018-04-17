import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streamovy {
    public static void main(String[] args) {

        System.out.println(
            IntStream.range(1,30).
                filter(n -> IntStream.range(1,n).filter(i->n%i == 0).sum() == n).
                boxed().collect(Collectors.toList())
        );
        System.out.println(
            Stream.of(1,2,3).flatMap(i -> Stream.of(3,2,1).map(j -> i+j)).collect(Collectors.toList())
        );
        System.out.println(
            IntStream.range(0,100).map(i -> i*2).filter(i -> i % 6 == 0).count()
        );
        System.out.println(
            IntStream.range(0,100).filter(i -> i % 6 == 0).map(i -> i*2).count()
        );

        int MAX = 1000;
        System.out.println(
            IntStream.range(0,MAX).filter(n -> n%2 == 0 || n%3 == 0 || n%5 == 0).boxed().collect(Collectors.toList())
        );
        System.out.println(
            IntStream.range(0,MAX).filter(n->n%30 == 0).boxed().collect(Collectors.toList())
        );
        System.out.println(
            IntStream.range(0,MAX).filter(n -> (IntStream.iterate(n, i->i/10).map(i->i%10).limit(16).sum())==n).boxed().collect(Collectors.toList())
        );
        System.out.println(
                IntStream.range(0,10).boxed().collect(Collectors.toList())
        );
    }
}
