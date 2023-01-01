package Java_16.src2;

// 장점
// 1. 코드의 간결성
// 2. 지연연산 수행
// 3. 병렬처리 가능

// 단점
// 1. 불필요한 사용 시, 가독성 저하
// 2. 람다식의 호출이 까다로움
// 3. 람다 stream 으로 단순 반복문 사용 시 성능 저a

interface LambdaTest{
    int addOne(int i);
}

public class Main {
    public static void main(String[] args) {
        LambdaTest test = i -> ++i;
        System.out.println(test.addOne(1));
    }
}
