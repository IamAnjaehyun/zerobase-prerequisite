package java02array;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        //1차원 배열
        System.out.println("== 1차원 배열 ==");
        int[] arr = {1, 2, 3, 4, 5};
        for (int item : arr) {
            System.out.println("item = " + item);
        }

        arr[1] = 100;
        System.out.println("arr = " + Arrays.toString(arr));

        //2차원 배열
        System.out.println("== 2차원 배열 ==");
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(arr2[0][1]);

        for (int row[] : arr2) {
            for (int item : row) {
                System.out.println("item = " + item);
            }
        }

        //ArrayList - 1차원, 2차원
        System.out.println("== ArrayList ==");
        ArrayList arrayList = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("arrayList = " + arrayList);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("arrayList = " + arrayList);
        arrayList.remove(2);
        System.out.println("arrayList = " + arrayList);
        arrayList.remove(Integer.valueOf(2));
        System.out.println("arrayList = " + arrayList);

        ArrayList arrayList2d = new ArrayList();
        ArrayList arrayList1d1 = new ArrayList(Arrays.asList(1, 2, 3));
        ArrayList arrayList1d2 = new ArrayList(Arrays.asList(4, 5, 6));
        arrayList2d.add(arrayList1d1);
        arrayList2d.add(arrayList1d2);
        System.out.println("arrayList1d1 = " + arrayList1d1);
        System.out.println("arrayList1d2 = " + arrayList1d2);
        System.out.println("arrayList2d = " + arrayList2d);
    }
}
