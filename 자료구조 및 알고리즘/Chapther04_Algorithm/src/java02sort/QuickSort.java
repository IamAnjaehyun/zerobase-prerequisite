package java02sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        //pivot는 자리 이미 찾음
        quickSort(arr, left, pivot - 1); //좌측에 대한 퀵소트
        quickSort(arr, pivot + 1, right); //좌측에 대한 퀵소트
    }

    public static int partition(int[] arr, int left, int right) { //자리교체 + pivot과 자리교체
        int pivot = arr[left]; //여러가지 방식 중 가장 좌측 데이터를 pivot를 성정했음
        int i = left;
        int j = right;

        while (i<j){
            while (arr[j] > pivot && i<j){
                j--;
            }

            while (arr[i] <= pivot && i<j){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,left,i);   // pivot와 i자리 교환
        return i;           //pivot 자리가 새로 i로 감
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //TestCode
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬 : " + Arrays.toString(arr));
    }
}
