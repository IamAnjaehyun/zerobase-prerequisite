package java03binarysearch;
//Practice4
//정수형 배열 weights 와 정수 days 가 주어진다
//weights 에는 각 상품의 무게 정보가 들어있고, days는 운송 납기일이다.
//상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
//days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

//입출력 예시
//weights : 1,2,3,4,5,6,7,8,9,10
//days : 5
//출력 : 15

//weights : 3,2,2,4,1,4
//days : 3
//출력 : 6
public class Practice4 {
    public static int solution(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w); //하나만 옮길 때 Max값이 우리가 구할 수 있는 최소한의 값
            right += w;              //최대한의 적재량
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int cur = 0;

            for (int w : weights) {
                if (cur + w > mid) { //현재무게 + 더한 무게 > 적재량 이면 필요 일수 증가 후 현재값 0으로
                    cnt += 1;
                    cur = 0;
                }
                cur += w; //무게 증가시킴
            }
            if (cnt > days) {
                left = mid + 1; //더 큰 적재량
            } else { //여유가 있을 때
                right = mid - 1;//더 작은 적재량
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //TestCode
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));
    }
}
