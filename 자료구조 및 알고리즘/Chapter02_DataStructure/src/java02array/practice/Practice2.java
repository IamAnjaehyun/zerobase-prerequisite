package java02array.practice;
//배열 arr 에서 target에 해당하는 값의 인덱스를 출력
//해당 값이 여러 개인 경우 가장 큰 인덱스 출력

//입출력 예시)
//배열 arr : 1,1,100,1,1,1,100
//target : 100
//결과 6

public class Practice2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 100, 1, 1, 1, 100};

        int target = 100;
        int result = -1;

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                if (i > result) {
                    result = i;
                }
            }
        }
        if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println("찾고자 하는 값이 없습니다.");
        }
    }
}
