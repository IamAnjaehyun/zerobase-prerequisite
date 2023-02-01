package lambda_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationExample1 {
    public static void main(String[] args) {
        String[] names = {"a", "b", "ab", "ab", "c"};
        System.out.println("Filtering");
        Stream<String> filterStream = Stream.of(names);
        filterStream.filter(name -> name.contains("a")).forEach(System.out::println);

        System.out.println("Distinct");
        Stream<String> distinctStream = Stream.of(names);
        distinctStream.distinct().forEach(System.out::println);

        System.out.println("Map");
        IntStream mapStream = IntStream.of(7, 3, 5, 4, 6);
        mapStream.map(num -> num + 2).forEach(System.out::println);

        System.out.println("flatMap");
        String[] wordArray = {"this is", "Intermediate Operation", "java jdk1.8"};
        Stream<String> flatMapStream = Stream.of(wordArray);
        flatMapStream.flatMap(s -> Stream.of(s.split(" "))).forEach(System.out::println);
    }
}
