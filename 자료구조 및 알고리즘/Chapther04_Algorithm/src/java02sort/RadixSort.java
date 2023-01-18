package java02sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public static void radixSort(int[] arr) {
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) { //0~9 끝자리
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen(arr); //자리수만큼 반복

        for (int i = 0; i < maxLen; i++) { //기수정렬에 대한 반복문
            for (int j = 0; j < arr.length; j++) { //자리에 맞는 큐 위치에 데이터 넣어야함 1의자리부터 시작~
                list.get((arr[j] / div) % 10).offer(arr[j]); //1의 자리를 갖고 %10을 하면 인덱스가 나오고 거기에 넣어줌
            }

            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j); //j번째 데이터 가져와서 while문 돌림

                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll(); //arr에 데이터 늘려가면서 1의 자리에 대한 정렬
                }
            }
            //그 다음 자리 정렬을 위해 초기화 및 변서 변경
            idx = 0;
            div *= 10;
        }

    }

    public static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int) Math.log10(arr[i]) + 1; //자리수
            if (maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        //TestCode
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬 : " + Arrays.toString(arr));
    }
}
