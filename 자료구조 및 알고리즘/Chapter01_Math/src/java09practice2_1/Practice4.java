package java09practice2_1;

//좋은 수 구하기
//짝수 인덱스에는 짝수 홀수 인덱스에는 소수
//5C1 4C1 하면되지만 재귀로 풀기 + 10^9 +7 로 나머지연산을 한 결과로 출력
public class Practice4 {
    final static int mod = (int) 1e9 + 7;

    public static int solution(long n) {
        return (int) (recursion(5, (n + 1) / 2) * recursion(4, n / 2) % mod);
    }

    public static long recursion(long x, long y) {
        if (y == 0) {
            return 1;
        }
        long p = recursion(x, y / 2);
        return p * p * (y % 2 > 0 ? x : 1) % mod;
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(50));
    }
}
