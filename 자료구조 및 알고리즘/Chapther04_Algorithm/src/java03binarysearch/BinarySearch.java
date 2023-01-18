package java03binarysearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("== 데이터가 있는 경우 ==");
        System.out.println(Arrays.binarySearch(arr,1));
        System.out.println(Arrays.binarySearch(arr,10));
        System.out.println(Arrays.binarySearch(arr,30));

        System.out.println("== 데이터가 없는 경우 ==");
        System.out.println(Arrays.binarySearch(arr,3)); //있었다면 인덱스 절대값 해서 -1 한 값
        System.out.println(Arrays.binarySearch(arr,11));//반전해서 1더하면 들어갈 위치
        System.out.println(Arrays.binarySearch(arr,35));

    }
}
