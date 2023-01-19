package java05greedy;

import java.util.HashMap;
import java.util.Map;

//거스름돈 문제
public class Main2 {
    public static void getChangeCoins(int receiveMoney, int price) {
        final int[] coins = {500, 100, 50, 10, 5, 1};
        HashMap<Integer, Integer> result = new HashMap<>(); //어떤동전 몇개인지

        int change = receiveMoney - price; //받은돈 - 가격
        int cnt = 0; //잔돈 개수

        for (int i = 0; i < coins.length; i++) { //큰 동전부터 빼자
            if (change < coins[i]) {
                continue;
            }
            int q = change / coins[i]; //현재꺼로 빼줄 수 있으면, 코인 가격으로 나눠줌 ( 몇개가 되는지 구해줌 )
            result.put(coins[i], result.getOrDefault(coins[i], 0) + q); // 해당 동전 개수 업데이트

            change %= coins[i]; //나머지
            cnt += q; //동전개수 업데이트
        }

        System.out.println("거스름돈 동전 개수 : " + cnt);
        for (Map.Entry<Integer, Integer> cur : result.entrySet()) {
            System.out.println(cur.getKey() + " : " + cur.getValue());
        }
    }

    public static void main(String[] args) {
        //TestCode
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
