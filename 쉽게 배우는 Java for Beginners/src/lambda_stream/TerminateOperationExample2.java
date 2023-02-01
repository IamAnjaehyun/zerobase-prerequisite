package lambda_stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TerminateOperationExample2 {
    public static void main(String[] args) {
        System.out.println("anyMatch");
        IntStream anyMatchStream = IntStream.of(7, 3, 5, 4, 6);
        System.out.println(anyMatchStream.anyMatch(n -> n % 2 == 1));

        System.out.println("allMatch");
        IntStream allMatchStream = IntStream.of(7, 3, 5, 4, 6);
        System.out.println(allMatchStream.allMatch(n -> n / 2 == 1));

        System.out.println("findFirst");
        IntStream findFirstStream = IntStream.of(7, 3, 5, 4, 6);
        OptionalInt findFirstResult = findFirstStream.sorted().findFirst();
        System.out.println(findFirstResult.getAsInt());

        System.out.println("findAny");
        IntStream findAnyStream = IntStream.of(7, 3, 5, 4, 6);
        OptionalInt findAnyResult = findAnyStream.sorted().findAny();
        System.out.println(findAnyResult.getAsInt());
    }
}
