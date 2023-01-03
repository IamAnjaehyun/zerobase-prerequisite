package java02array.practice;

//배열 arr의 모든 데이터에 대해서, 짝수 데이터들의 평균과 홀수 데이터들의 평균을 구하시오

//입출력 예시
//배열 arr : 1,2,3,4,5,6,7,8,9
//결과 :
//짝수 평균 : 5.0
//홀수 평균 : 5.0
public class Practice1 {
    public static void main(String[] args) {
        int[] arr = new int[9];

        int aSum = 0;
        int aCnt = 0;
        int bSum = 0;
        int bCnt = 0;

        for (int i = 0; i < 9; i++) {arr[i] = i + 1;}

        for (int item : arr) {
            if (item % 2 == 0) {
                aSum += item;
                aCnt++;
            } else {
                bSum += item;
                bCnt++;
            }
        }
        System.out.println("짝수 값의 평균 : " + aSum / aCnt);
        System.out.println("홀수 값의 평균 : " + bSum / bCnt);

    }
}
