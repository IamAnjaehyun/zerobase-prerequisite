package java03numberofcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// 기초수학 - 경우의 수
public class Main {
    public static void main(String[] args) {
        // 1. 합의 법칙
        System.out.println("=== 합의 법칙 ===");
        // 두 개의 주사위를 던졌을 때 합이 3 또는 4의 배수일 경우의 수
        int[] dice1 = {1,2,3,4,5,6};
        int[] dice2 = {1,2,3,4,5,6};

        int nA = 0;
        int nB = 0;
        int nAandnB = 0;

        // 기본 풀이
        for(int item1 : dice1){
            for(int item2 : dice2){
                if((item1 + item2) % 3 == 0){
                    nA += 1;
                }
                if((item1 + item2) % 4 == 0){
                    nB += 1;
                }
                if((item1 + item2) % 12 == 0){
                    nAandnB += 1;
                }
            }
        }
        System.out.println("결과 : "+ (nA + nB - nAandnB));

        // HashSet 이용 -> hashset이라 중복은 알아서 빠짐
        HashSet<ArrayList> allCase = new HashSet<>();
        for(int item1 : dice1){
            for(int item2 : dice2){
                if((item1 + item2) % 3 == 0 || (item1 + item2) % 4 == 0){
                    ArrayList list = new ArrayList(Arrays.asList(item1, item2));
                    allCase.add(list);
                }
            }
        }
        System.out.println("결과 : " + allCase.size());
        // 2. 곱의 법칙
        System.out.println("=== 곱의 법칙 ===");

        // 두 개의 주사위 a, b 를 던졌을 때는 a는 3의 배수, b는 4의 배수인 경우의 수
        nA = 0;
        nB = 0;

        for(int item1 : dice1){
            if(item1 % 3 == 0){
                nA++;
            }
        }

        for(int item2 : dice2){
            if(item2 % 4 == 0){
                nB++;
            }
        }
        System.out.println("결과 : " + (nA * nB));
    }
}
