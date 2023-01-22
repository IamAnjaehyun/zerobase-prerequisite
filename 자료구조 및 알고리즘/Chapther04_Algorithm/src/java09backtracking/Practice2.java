package java09backtracking;
//Practice2
//숫자 7193은 7193도 소수이고,
// 719, 71, 7도 각각 소수이다.
//n이 주어졌을 때, n자리 수 중에 위와 같은 소수를 찾는 프로그램을 작성하세요.


import java02array.Array;

import java.util.ArrayList;

//입출력 예시
//입력 n : 3
//출력 :[233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797]
public class Practice2 {
    public static ArrayList<Integer> result;

    public static ArrayList<Integer> solution(int n) {
        result = new ArrayList<>();

        int[] primeNum = {2, 3, 5, 7};
        for (int i = 0; i < primeNum.length; i++) {
            //backTracking
            backTracking(primeNum[i], 1, n);
        }

        return result;
    }

    public static void backTracking(int prime, int len, int n) {
        if (len >= n) {
            result.add(prime);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0 || i != 5) {
                int primeCandidate = prime * 10 + i; //기존 값 * 10 + i
                if (isPrime(primeCandidate)) {
                    backTracking(primeCandidate, len + 1, n);
                }
            }
        }
    }

    //소수 판별
    public static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
