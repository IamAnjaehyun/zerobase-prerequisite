package java02sort;
//Practice3
//intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
//오버랩 되는 구간을 합치는 프로그램을 작성하세요.
//합친 구간은 오름차순으로 정렬해서 변환하시오.


//입출력 예시
//입력 : [2,6],[1,3],[15,18],[8,10]
//출력 : [1, 6] [8, 10] [15, 18]

import java.util.ArrayList;
import java.util.Arrays;

public class Practice3 {
    public static ArrayList<int[]> solution(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return new ArrayList<>();
        }

        //첫 값 기준으로 sort
        sort(intervals);

        //순회하면서 구간 겹치나 확인
        ArrayList<int[]> result = new ArrayList<>();
        int[] curInterval = intervals[0];
        result.add(curInterval);

        for (int i = 1; i < intervals.length; i++) {
            if(curInterval[1] >= intervals[i][0]){//현재 커런트 인터벌의 뒷부분이 다음 인터벌의 앞부분보다 크거나 같으면 겹치니까 합침
                curInterval[1] = intervals[i][1];
            }else {
                curInterval = intervals[i];
                result.add(curInterval);
            }
        }

        return result;
    }

    //복습차원 퀵소트
    public static void sort(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
    }

    //복습차원 퀵소트
    public static void quickSort(int[][] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[][] arr, int left, int right) {
        int pivot = arr[left][0];
        int i = left;
        int j = right;

        while (i < j) {
            while (arr[j][0] > pivot && i < j) {
                j--;
            }
            while (arr[i][0] <= pivot && i < j) {
                i++;
            }
            swap(arr, i, j);

        }
        swap(arr, left, i);
        return i;
    }

    public static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i]; //이차원배열이니까 int[] temp!!
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //TestCode
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        for (int[] item : solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();
    }

}
