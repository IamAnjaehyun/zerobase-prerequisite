package java02sort;

import java.util.Arrays;

//알고리즘 - 정렬_1
public class Main {
    //버블 정렬
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

//        for (int i = arr.length-1; i >0; i--) {
//            for (int j = 0; j < i; j++) {
//                if(arr[j] > arr[j+1]){
//                    int temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

    }

    //삽입 정렬
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    //선택 정렬
    public static void selectSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min]) {
//                    min = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = temp;
//        }

        for (int i = arr.length - 1; i > 0; i--) {
            int max = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }

    public static void main(String[] args) {
        //TestCode
        int[] arr = {5, 3, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬 : " + Arrays.toString(arr));

        arr = new int[]{5, 3, 2, 7, 1, 4};
        insertSort(arr);
        System.out.println("삽입 정렬 : " + Arrays.toString(arr));

        arr = new int[]{5, 3, 2, 7, 1, 4};
        selectSort(arr);
        System.out.println("선택 정렬 : " + Arrays.toString(arr));
    }
}
