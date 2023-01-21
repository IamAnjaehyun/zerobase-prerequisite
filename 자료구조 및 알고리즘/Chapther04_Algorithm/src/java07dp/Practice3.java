package java07dp;
//Practice3
//배낭에 물품을 담으려 한다.
//배낭에는 k 무게 만큼의 물품을 담을 수 있다.
//n 개의 물품이 주어지고 이 물품의 무게와 가치 정보가 items 2차원 배열에 주어졌을 때,
//최대 가치가 되도록 물품을 담았을 때의 가치를 출력하는 프로그램을 작성하세요.

//입출력 예시
//items : {{6,13},{4,8},{3,6},{5,12}}
//n : 4
//k : 7
//출력 :14
public class Practice3 {
    public static int solution(int[][] items, int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (items[i][0] > j) { //현재 넣으려고 하는 물건이 j보다 큰 경우
                    dp[i + 1][j] = dp[i][j];
                } else { //물건을 넣을 수 있는 경우 , 새로 넣으려는 무게 vs 원래 들어있던 무게 비교해야함
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - items[i][0]] + items[i][1]); //원래있던거 vs 현재 넣으려고 하는 아이템의 무게를 뺀 위치에 어떤값이 있었는지 + 지금 넣으려고 하는 아이템의 가치
                }
            }

        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        //TestCode
        int[][] items = {{5, 13}, {4, 8}, {3, 6}, {5, 12}};
        System.out.println(solution(items, 4, 7)); //14
    }
}
