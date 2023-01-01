package Java_16.src2;

import java.util.function.*;

public class OtherFunctionalInterfaceExample {
    public static void main(String[] args) {
        //문자열의 길이가 0인지 확인
        Predicate<String> isEmptyString = String::isEmpty;

        //문자열 앞에 "+" 추가
        Consumer<String> sentence = (str) -> System.out.println("+"+str);

        //문자열을 매개변수로 받고 Integer형으로 반환해 문자열의 길이 나타냄
        Function<String, Integer> strLength = (String s) -> s.length();

        //현시점의 시간을 ms로 long으로 반환
        Supplier<Long> currentTime = ()-> System.currentTimeMillis();

        //매개변수가 하나 . 연산한 결과 반환
        UnaryOperator<Integer> twoSum = (i) -> i+i;


        System.out.println(isEmptyString.test(""));
        sentence.accept("Consumer Class");
        System.out.println(strLength.apply("Function"));
        System.out.println(currentTime);
        System.out.println(twoSum.apply(123));
    }
}
