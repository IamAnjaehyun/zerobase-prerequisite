package java12practice;

import java.util.Arrays;

public class Practice1 {
    public static int solution(int n, int[] times) {
        if (times == null || times.length == 0) {
            return -1;
        }

        Arrays.sort(times);
        int left = 0;
        int right = times[times.length - 1] * n;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i]; //mid시간내에 몇명 진료할 수 있는지
            }

            if (cnt < n) { //시간 내에 몇명까지 진료할 수 있는지 세어봤더니 시간 부족해서 시간 늘려줘야함
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //TestCode
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }
}
