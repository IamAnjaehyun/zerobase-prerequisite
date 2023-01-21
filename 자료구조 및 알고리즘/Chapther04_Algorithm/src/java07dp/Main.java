package java07dp;

//알고리즘 - 다이나믹 프로그래밍 ( 피보나치 수열 )
public class Main {
    //피보나치 수열 (일반 풀이 - O(n^2)
    //계산했던 부분도 다시 계산
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    //피보나치 수열 (DP 풀이 - 타뷸레이션 - O(n)) 아래서부터
    public static int fibDP(int n) {
        int[] dp = new int[n < 2 ? 2 : n + 1]; //저장소
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //피보나치 수열 (DP 풀이 - 메모이제이션 - O(n)) 위에서부터
    static int[] dp = new int[8];

    public static int fibDP2(int n) {
        if (n <= 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibDP2(n - 1) + fibDP2(n - 2);

        return dp[n];
     
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
    }

}
