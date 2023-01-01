package Java_17.src2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationExample2 {
    public static void main(String[] args) {

        System.out.println("==Sorted==");
        IntStream unSortedStream = IntStream.of(7,3,5,4,6);
        unSortedStream.sorted().forEach(System.out::println);

        System.out.println("==limit==");
        IntStream limitStream = IntStream.of(7,3,5,4,6);
        limitStream.limit(3).forEach(System.out::println); //앞에꺼 3개

        System.out.println("==skip==");
        IntStream skipStream = IntStream.of(7,3,5,4,6);
        skipStream.skip(3).forEach(System.out::println); //3개 뛰어넘고 시작

        System.out.println("==peek==");
        IntStream peekStream = IntStream.of(7,3,5,4,6);
        peekStream.peek(i -> System.out.println("sorted 수행 : "+ i)).forEach(System.out::println);

    }
}
