package lambda_stream;

import java.util.function.*;

public class OtherFunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<String> isEmptyString = String::isEmpty;                      // 문자열의 길이가 0인지 체크
        Consumer<String> sentence = (str) -> System.out.println("+" + str);     // 매개변수로 받은 문자 앞에 + 추가
        Function<String, Integer> strLength = (String s) -> s.length();         // 문자열 길이 반환
        Supplier<Long> currentTime = () -> System.currentTimeMillis();          // 현시점의 시간 반환
        UnaryOperator<Integer> twoSum = (i) -> i+i;                             // 연산결과를 반환

        System.out.println(isEmptyString.test(""));
        sentence.accept("Consumer Class");
        System.out.println(strLength.apply("Function"));
        System.out.println(currentTime);
        System.out.println(twoSum.apply(123));
    }
}
