package java02array.practice;

//배열 arr의 값을 오름차순으로 출력

import java.util.Arrays;

//입출력 예시)
//arr : 5, 3, 1, 4, 6, 1
//arr : 1, 1, 3, 4, 5, 6
public class Practice5 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
