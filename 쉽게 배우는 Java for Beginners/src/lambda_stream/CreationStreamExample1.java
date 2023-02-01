package lambda_stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreationStreamExample1 {
    public static void main(String[] args) {
        //배열에서 스트림 생성
        String[] arr = new String[]{"a","b","c","d"};
        Stream<String> arrayToStream = Arrays.stream(arr);

        //Collection에서 스트림 생성
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> listToStream = list.stream();

        //지정된 범위의 연속된 정수에서 스트림 생성
        IntStream continuousIntStream = IntStream.rangeClosed(1,4);

        //특정 타입의 난수로 이루어진 스트림 생성
        IntStream randomStream = new Random().ints(4);
    }
}
