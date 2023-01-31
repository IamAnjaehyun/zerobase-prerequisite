package java07practice;

import java.util.PriorityQueue;

public class Practice8 {

    public static boolean solution(int[] target) {
        if (target == null || target.length == 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        int sum = 0;
        for (int num : target) {
            sum += num;
            pq.add(num);
        }

        while (pq.peek() != 1) { //1들만 남았다
            int num = pq.poll();
            sum -= num;

            if (num <= sum || sum < 1) { //안되는 애들 조기종료
                return false;
            }

            num -= sum;
            sum += num;
            pq.add(num > 0 ? num : sum);
        }

        return true;
    }

    public static void main(String[] args) {
        //TestCode
        int[] target = {9, 3, 5};
        System.out.println(solution(target));

        target = new int[]{8, 5};
        System.out.println(solution(target));

        target = new int[]{1, 1, 1, 2};
        System.out.println(solution(target));

    }
}
