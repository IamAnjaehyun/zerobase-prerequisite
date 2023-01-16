package java05priorityqueue;
//Practice3
//nums 배열에 주어진 정수들 중에서 k 번째로 큰 수를 반환하는 프로그램을 작성하세요.

//입력 예시
//입력 : 3,1,2,7,6,4
//k : 2
//출력 : 6

import java.util.Arrays;
import java.util.PriorityQueue;

//입력 : 1,3,7,4,2,8,9
//k : 7
//출력 : 1
public class Practice3 {
    public static int solution1(int[] nums, int k) {//MinHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //기본 형태 오름차순
        for (int x : nums) {
            pq.offer(x);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int solution2(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k]; //오름차순이니까
    }

    public static void main(String[] args) {
        //TestCode
        int[] nums = {3, 1, 2, 7, 6, 4};
        System.out.println(solution1(nums, 2));
        System.out.println(solution2(nums, 2));
        System.out.println();

        nums = new int[]{1, 3, 27, 4, 2, 8, 9};
        System.out.println(solution1(nums, 7));
        System.out.println(solution2(nums, 7));
    }
}
