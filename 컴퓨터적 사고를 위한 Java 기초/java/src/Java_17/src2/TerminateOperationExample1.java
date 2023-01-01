package Java_17.src2;


import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TerminateOperationExample1 {
    public static void main(String[] args) {
        System.out.println("==count==");
        IntStream countStream = IntStream.of(7,3,5,4,6);
        System.out.println(countStream.skip(2).count());

        System.out.println("==average==");
        IntStream averageStream = IntStream.of(7,3,5,4,6);
        OptionalDouble averageResult = averageStream.skip(2).average();
        System.out.println(averageResult.getAsDouble());

        System.out.println("==collect==");
        IntStream collectStream = IntStream.of(7,3,5,4,6);
        List<Integer> collectedList = collectStream.sorted().boxed().collect(Collectors.toList());
        for(int element : collectedList){
            System.out.println(element);
        }

        System.out.println("==reduce==");
        IntStream reduceStream = IntStream.of(7,3,5,4,6);
        Optional<Integer> reduceResult = reduceStream.sorted().boxed().reduce((num1,num2)->num1*num2);
        System.out.println(reduceResult.get());
    }
}
