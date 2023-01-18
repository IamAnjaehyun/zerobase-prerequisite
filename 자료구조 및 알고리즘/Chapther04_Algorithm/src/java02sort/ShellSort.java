package java02sort;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;

        //gap간격을 갖고 삽입정렬
        for (int g = gap; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                int temp = arr[i];

                int j = 0;
                for (j = i - g; j >= 0; j -= g) {
                    if (arr[j] > temp) {
                        arr[j + g] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + g] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //TestCode
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("셸 정렬 : " + Arrays.toString(arr));
    }
}
