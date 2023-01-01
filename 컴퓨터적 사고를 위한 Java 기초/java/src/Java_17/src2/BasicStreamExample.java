package Java_17.src2;
//Stream 특징
//1. 원본 데이터 변경 불가
//2. 일회용
//3. 병렬 처리 가능
//4. 내부 반복으로 작업 처리
//5. 기본 데이터 형을 처리할 수 있는 래퍼 스트림 지원 (Int/Double/LongStream)
import java.util.Arrays;
//distinct -> 중복 삭제
public class BasicStreamExample {
    public static void main(String[] args) {

        String[] stringArray = {"this","is","a","stream","example","is","this"};
        Arrays.stream(stringArray).distinct().forEach(System.out::println);

        int[] numArray ={1,2,3,4,5,6,1,2,3};
        int sum = Arrays.stream(numArray).distinct().sum();
        System.out.println(sum);
    }
}
