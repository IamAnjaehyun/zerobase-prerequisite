package Java_17.src2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationExample1 {
    public static void main(String[] args) {

        System.out.println("==filter==(a 포함된 것만 출력)");
        String[] names = {"a","b","ab","ab","c"};
        //names를 filterStream에 넣음
        Stream<String> filterStream = Stream.of(names);
        //"a" 포함된 것 출력
        filterStream.filter(name -> name.contains("a")).forEach(System.out::println);

        System.out.println("==distinct==(중복 제거)");
        Stream<String> distinctStream = Stream.of(names);
        distinctStream.distinct().forEach(System.out::println);

        System.out.println("==map==(rambda 사용 +2값 출력)");
        IntStream mapStream = IntStream.of(7,3,5,4,6);
        mapStream.map(num -> num+2).forEach(System.out::println);

        System.out.println("==flatMap==(split으로 공백기준 자름)");
        String[] wordArray = {"this is", "Intermediate Operation", "Java jdk1.8"};
        Stream<String> flatMapStream = Stream.of(wordArray);
        flatMapStream.flatMap(s -> Stream.of(s.split(" "))).forEach(System.out::println);
    }
}
