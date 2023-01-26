package java12practice;

import java.util.Arrays;

public class Practice8 {
    public static int solution(int[] weight) {

        Arrays.sort(weight);

        int cur = 0;
        for (int i = 0; i < weight.length; i++) {
            if (cur + 1 < weight[i]) {
                break;
            }
            cur += weight[i];
        }
        return cur + 1;
    }

    public static void main(String[] args) {
        //TestCode
        int[] weight = {6, 1, 2, 3, 1, 7, 30};
        System.out.println(solution(weight));
    }
}
