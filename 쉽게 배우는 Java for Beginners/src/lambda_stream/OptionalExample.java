package lambda_stream;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalNullStr = Optional.ofNullable(null);
        Optional<String> optionalStr = Optional.ofNullable("null");
        Optional<Integer> optionalInt = Optional.of(0);
        OptionalDouble optionalDouble = OptionalDouble.of(3.14);

        //Optional 객체의 값이 null인지 여부 반환
        System.out.println(optionalNullStr.isPresent());
        //Optional 객체의 값이 null인지 매개변수 출력
        System.out.println(optionalNullStr.orElse("NULL값"));
        //Optional 객체의 값이 존재하면 매개변수로 전달된 명령문 수행
        optionalStr.ifPresent(System.out::println);
        //Optional 값 출력
        System.out.println(optionalInt.get());
        //OptionalDouble 값 출력
        System.out.println(optionalDouble.getAsDouble());
    }
}
