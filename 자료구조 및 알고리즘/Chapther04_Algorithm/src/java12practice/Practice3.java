package java12practice;

import java.util.ArrayList;

public class Practice3 {
    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }

        boolean[] used = new boolean[items.length + 1];

        int idx = 0;
        int cnt = 0;
        while (cnt < n) {
            if (!used[items[idx]]) { //사용중이 아니면
                used[items[idx]] = true; //콘센트 연결 후 true
                cnt++;
            }
            idx++; //다음 위치 , 같은거면 넘어감
        }

        int result = 0;
        while (idx < items.length) {
            if (!used[items[idx]]) {//현재 위치 인덱스의 전기제품이 연결되어있지 않은 경우
                ArrayList<Integer> list = new ArrayList<>(); //다음에 다시 꽂아야 할 애 체크해봐야함
                for (int i = idx; i < items.length; i++) {
                    if (used[items[i]] && !list.contains(items[i])) { //사용할거고, 담겨있지 않으면 리스트에 추가
                        list.add(items[i]); //나중에 쓸 애는 추가됨
                    }
                }

                if (list.size() == n) { //나중에 다시 다 사용함
                    used[list.get(n - 1)] = false; //가장 마지막에 사용할 놈 빼버림
                } else { //사이즈가 n보다 작음 둘 중 하나는 안쓰거나 둘다 안씀
                    for (int i = 1; i < items.length; i++) {
                        if (used[i] && !list.contains(i)) { //나중에 안쓸녀석
                            used[i] = false;
                            break;
                        }
                    }
                }
                used[items[idx]] = true;
                result++;
            }

            idx++;
        }

        return result;
    }

    public static void main(String[] args) {
        //TestCode
        int n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution(n, items));
    }
}
