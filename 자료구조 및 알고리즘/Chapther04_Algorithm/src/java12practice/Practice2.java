package java12practice;

public class Practice2 {
    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }

        int[] selected = new int[types + 1];

        int cnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (selected[plates[i]] == 0) { //선택안됨
                cnt++;
            }
            selected[plates[i]]++; //또걸리면 두번째 먹은거
        }
        max = cnt;

        for (int i = 1; i < plates.length; i++) {

            if (max <= cnt) {
                if (selected[coupon] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

            int p1 = i - 1;
            int p2 = (i + n - 1) % plates.length; //뺑뺑이위함 오른쪽으로 밀어

            selected[plates[p1]]--;
            if (selected[plates[p1]] == 0) {
                cnt--; //오른쪽으로 밀었으니 --
            }

            if (selected[plates[p2]] == 0) {
                cnt++;
            }
            selected[plates[p2]]++;
        }


        return max; //최대 종류
    }

    public static void main(String[] args) {
        //TestCode
        int n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30;
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }
}
