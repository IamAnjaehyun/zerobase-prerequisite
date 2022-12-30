package Java_18_2.src;

public class Practice5 {
    public static int solution(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int result = 1;
        int upCnt = 1;
        int downCnt = 1;
        int peak = 0; //다운으로 많이갔을때 기존 피크치 초과하는지(최고치)

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) { //오른쪽이 왼쪽보다 클 때
                upCnt++;
                peak = upCnt; //갱신
                downCnt = 0; //down쪽 가다가 up으로 전환됐으면 down 0으로 초기화시켜줌
                result += upCnt;
            } else if (ratings[i] == ratings[i - 1]) { //등수가 같으면 그냥 1개만 주면 됨
                upCnt = 1;
                downCnt = 0;
                peak = 0;
                result += 1;
            } else { //작아지는 쪽으로 이동할 때
                downCnt++;
                upCnt = 1;
                result += downCnt;

                if (peak <= downCnt) { //연속가다가 기존 피크치 넘으면 하나씩 늘려줘야 함
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings));

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings));
    }
}
