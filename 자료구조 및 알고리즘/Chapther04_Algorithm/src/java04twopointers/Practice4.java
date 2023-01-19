package java04twopointers;
//Practice4
//주어진 nums 배열에서 3개의 합이 0이 되는 모든 숫자들을 출력하세요.
//중복된 숫자 set은 제외하고 출력하세요.

//입출력 예시
//nums : {-1,0,1,2,-1,-4}
//출력 : [[-1,-1,2],[-1,0,1]]

//nums : {1,-7,6,3,5,2}
//출력 : [[-7,1,6],[-7,2,5]]

import java.util.ArrayList;
import java.util.Arrays;

public class Practice4 {
    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int p1 = i + 1;
                int p2 = nums.length - 1;
                int sum = 0 - nums[i]; //sum값 반전

                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == sum) { // -> p1+p2+num[i] = 0 이랑 같은거임 (위에서 sum 반전 시켰음)
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2])));
                        //해쉬셋 쓰는게 더 편함
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) {
                            p1++; //연속된 같은수 건너뛰기
                        }

                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) {
                            p2--; //p2쪽도 연속된 같은 수 건너뛰기
                        }

                        p1++; //한칸씩 이동
                        p2--; //한칸씩 이동
                    } else if (nums[p1] + nums[p2] < sum) { //두개 더했지만 sum보다 작을 때
                        p1++;
                    } else { //sum보다 커졌을 때
                        p2--;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        //TestCode
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution(nums));

        nums = new int[]{1, -7, 6, 3, 5, 2};
        System.out.println(solution(nums));

    }
}
