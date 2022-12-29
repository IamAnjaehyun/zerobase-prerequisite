package Java_18_1.src;

public class Practice1 {
    public static void solution(int num) {
        int numReverse = 0; //뒤집은거 담을 변수
        boolean isMinus = false; //마이너스 판별 변수

        if (num < 0) { //마이너스면 일단 양수로 만듬
            isMinus = true;
            num *= -1;
        }

        while (num > 0) { //양수면 num 값 10씩 나눠서 1의자리 수 빼놓고 numReverse에 하나씩 저장 & 저장하고 하나씩 추가해야되니까 *10 + r
            int r = num % 10;
            num /= 10;
            numReverse = numReverse * 10 + r;
        }
        System.out.println(isMinus ? numReverse * -1 : numReverse); //음수면 양수로 바꿨다가 다시 마이너스로 바꾼 뒤 출력 아니면 그냥출력
    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
