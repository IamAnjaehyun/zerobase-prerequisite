package java02sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int[] temp, int left, int right) { //정렬하고자 하는 배열 분할 temp 는 임시 메모리 공간
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid); //좌측
            mergeSort(arr, temp, mid + 1, right); //우측
            merge(arr, temp, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] temp, int left, int right, int mid) { //배열 합치기
        int p = left;
        int q = mid + 1;
        int idx = p;

        while (p <= mid || q <= right) { //유효구간 안에 있을 때
            if (p <= mid && q <= right) {//두 값 모두 유효구간
                if (arr[p] <= arr[q]) { //왼쪽이 더 작으면
                    temp[idx++] = arr[p++];
                } else { //오른쪽이 더 작으면
                    temp[idx++] = arr[q++];
                }
            } else if (p <= mid && q > right) { //좌측만 남았을 때 (오른쪽엔 더이상 데이터 없음)
                temp[idx++] = arr[p++];
            } else {
                temp[idx++] = arr[q++];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        //TestCode
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("합병 정렬 : " + Arrays.toString(arr));
    }
}
