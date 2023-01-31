package java07practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice6 {

    public static int solution(int[][] times, int targetFriend) {
        if (times == null || times.length == 0 || times[0].length == 0) {
            return -1;
        }
        int targetArrival = times[targetFriend][0];

        //도착한 시간 순서대로 오름차순
        Arrays.sort(times, (x, y) -> x[0] - y[0]);

        //의자관리
        PriorityQueue<Integer> pqChair = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            pqChair.offer(i);
        }

        //친구관리
        PriorityQueue<int[]> pqFriend = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        for (int i = 0; i < times.length; i++) {
            //먼저 도착하는 애보다 떠나는 애가 있으면 의자 반납
            while (!pqFriend.isEmpty() && pqFriend.peek()[0] <= times[i][0]) {
                pqChair.offer(pqFriend.poll()[1]);
            }

            if (times[i][0] == targetArrival) {
                break;
            }
            //도착한 친구에 대해 친구가 떠나는 시간 기준 번호가 가장 낮은 의자 줌
            pqFriend.offer(new int[]{times[i][1], pqChair.poll()});
        }

        return pqChair.peek();
    }

    public static void main(String[] args) {
        //TestCode
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1));


        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0));

    }
}
