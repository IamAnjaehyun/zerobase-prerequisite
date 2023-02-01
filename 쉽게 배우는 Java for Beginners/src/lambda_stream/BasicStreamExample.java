package lambda_stream;

import java.util.Arrays;

public class BasicStreamExample {
    public static void main(String[] args) {
        //distinct -> 중복 제외
        String[] stringArray = {"this", "is", "a", "stream", "example", "is", "this"};
        Arrays.stream(stringArray).distinct().forEach(System.out::println);

        int[] numArray = {1, 2, 3, 4, 5, 6, 1, 2, 3};
        int sum = Arrays.stream(numArray).distinct().sum();
        System.out.println(sum);
    }
}
