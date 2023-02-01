package lambda_stream;

import java.util.stream.IntStream;

public class IntermediateOperationExample2 {
    public static void main(String[] args) {
        System.out.println("Sorted");
        IntStream unsortedStream = IntStream.of(7, 3, 5, 4, 6);
        unsortedStream.sorted().forEach(System.out::println);

        System.out.println("limit");
        IntStream limitStream = IntStream.of(7, 3, 5, 4, 6);
        limitStream.limit(3).forEach(System.out::println);

        System.out.println("skip");
        IntStream skipStream = IntStream.of(7, 3, 5, 4, 6);
        skipStream.skip(3).forEach(System.out::println);

        System.out.println("peek");
        IntStream peekStream = IntStream.of(7, 3, 5, 4, 6);
        peekStream.sorted().peek(i -> System.out.println("soted 수행 : " + i)).forEach(System.out::println);
    }
}
