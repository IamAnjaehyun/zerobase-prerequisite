package lambda_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CreationStreamExample2 {
    public static void main(String[] args) {
        //람다를 이용한 스트림 생성 generate
        Stream<Integer> lambdaIterate = Stream.iterate(0, n -> n + 1);
        Stream<Double> lambdaGenerateStream = Stream.generate(Math::random); //error

        //파일 스트림 생성
        try{
            Stream<String> fileStream = Files.lines(Paths.get("path"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //빈 스트림 생성
        Stream emptyStream = Stream.empty();
    }
}
