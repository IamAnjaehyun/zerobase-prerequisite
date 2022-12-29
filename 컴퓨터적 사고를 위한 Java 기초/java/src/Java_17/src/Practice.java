package Java_17.src;// Practice
// 하기 예제를 스트림으로 구현해보세요.

import java.util.stream.IntStream;

public class Practice {
    public static void main(String[] args) {

        // 예제: 1~10 숫자 중 짝수 들의 합
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;

        for (int num: arr) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        System.out.println("sum = " + sum);


        // 스트림으로 구현
//        int sum2 = IntStream.range(1,11).filter(n -> n % 2 == 0).reduce((x,y) -> x+y).getAsInt(); //한번에 성공 ㅋㅋ good!
        int sum2 = IntStream.range(1,11).filter(n -> n % 2 == 0).sum(); //이게 더 짧다
        System.out.println("sum2 = " + sum2);
    }
}
