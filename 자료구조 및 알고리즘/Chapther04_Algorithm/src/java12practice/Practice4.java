package java12practice;

public class Practice4 {

    final static int numOfTree = 2;

    public static int solution(int[] order, int k) {
        if (order == null || order.length == 0) {
            return -1;
        }

        int n = order.length;
        int[][][] dp = new int[k + 2][numOfTree + 1][n]; //0~2번 이동 / 나무 1번 2번 /

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 2; j++) {
                if (order[i] == 1) {
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]) + 1; //1번에서 떨어지는 경우
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i - 1]);
                } else { //두번째 나무에서 포도 떨어지는 케이스
                    if (i == 1 && j == 1) { //이동 안하는 케이스
                        continue;
                    }
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]);
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i - 1]) + 1; //2번에서 떨어지는 경우
                }
            }

        }
        int result = 0;
        for (int i = 1; i < k + 2; i++) {
            result = Math.max(result, Math.max(dp[i][1][n - 1], dp[i][2][n - 1]));

        }

        return result;
    }


    public static void main(String[] args) {
        //TestCode
        int[] order = {2, 1, 1, 2, 2, 1, 1};
        int k = 2;
        System.out.println(solution(order, k));
    }
}
