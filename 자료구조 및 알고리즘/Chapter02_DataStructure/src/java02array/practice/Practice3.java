package java02array.practice;
//배열 arr의 데이터 순서를 거꾸로 변경하세요.
//추가 배열을 사용하지 않고 구현

import java.util.Arrays;

//입출력 예시)
//arr : 1,3,5,7,9
//결과 : 9,7,5,3,1
public class Practice3 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        //이건 내림차순
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[i] < arr[j]){
//                    int temp = arr[i];
//                    arr[i] =arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        //자리만 바꿔주기 (가운데 값은 안바꿔도 되니까 /2 만 하고 +1안함
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
