package Java_16.src;

// Java 프로그래밍 - 람다식
// 메소드 대신 하나의 식으로 표현하는 것
// 장점 - 코드 간결해짐 / 가독성 생산성 높아짐
// 단점 - 재사용 불가 / 디버깅 어려움 / 재귀함수로는 맞지않음
interface ComputeTool {
    public abstract int compute(int x, int y);

    public abstract int compute2(int x, int y);
}



public class Main {

    public static void main(String[] args) {

        ComputeTool computeTool = new ComputeTool() {
            @Override
            public int compute(int x, int y) {
                return x+y;
            }

            @Override
            public int compute2(int x, int y) {
                return x-y;
            }
        };
        System.out.println(computeTool.compute(1,2));
        // 람다식 - > 익명클래스 두개면 못쓴다.
//        ComputeTool computeTool2 = (x,y)->{return x+y;};
//        System.out.println("ramda" + computeTool2.compute(1,2));

    }
}
