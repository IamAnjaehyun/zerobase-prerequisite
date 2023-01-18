package java02sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CountingSort {
    public static void countingSort(int[] arr) {
        //카운팅 테이블
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) { //반복문 돌면서 해당 위치에 카운트 증가시켜줌
            cntArr[arr[i]]++;
        }
        int idx = 0;
        //돌면서 출력시켜주면 됨
        for (int i = 0; i < cntArr.length; i++) {
            while (cntArr[i] > 0) {
                arr[idx++] = i;
                cntArr[i] -= 1; //cnt 넣을때마다 하나씩 빼줌
            }
        }
//        //max 값이 엄청나게 클 땐 HashMap 사용하여 배열 잡는게 더 빠름(HashMap 부가기능있어서 max값이 작으면 이게 더 부담)
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int item : arr){
//            map.put(item,map.getOrDefault(item,0)+1);
//        }
//
//        int idx2= 0;
//        ArrayList<Integer> list = new ArrayList<>(map.keySet());
//        Collections.sort(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            int cnt = map.get(list.get(i));
//            while (cnt>0){
//                arr[idx2] = list.get(i);
//                cnt--;
//            }
//        }

    }

    public static void main(String[] args) {
        //TestCode
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        countingSort(arr);
        System.out.println("카운팅 정렬 : " + Arrays.toString(arr));
    }
}
