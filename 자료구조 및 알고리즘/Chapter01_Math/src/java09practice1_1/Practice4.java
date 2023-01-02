package java09practice1_1;

import java.util.HashSet;

public class Practice4 {
    public static boolean solution(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (set.add(n)) { //set에 들어가지면 1 중복이라 안들어가지면 -1(false)
            //제곱의 합을 의미 squareSum
            int squareSum = 0;

            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if(squareSum ==1){
                return true;
            }else{
                n = squareSum;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
