package java07practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//자물쇠 몇번 이동시켜야 target에 달성하는가? *deadends 피해서 가야함
//bfs 사용
//전후 이동관계나 노드에 대한게 보이면 그래프로 구성 후 search
public class Practice4 {
    public static int solution(String[] deadends, String target) {
        if (target == null || target.length() == 0) {
            return -1;
        }

        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>(); //bfs쓸거니까

        queue.offer("0000");
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curNum = queue.poll();

                if (!visited.add(curNum)) { //이미 방문 했던애
                    continue;
                }

                if (curNum.equals(target)) { //번호가 이동하려는 타겟과 같음
                    return cnt; //현재까지 카운팅한 변수
                }

                for (String nextNum : getNextNums(curNum.toCharArray())) { //이동가능한 다음 번호들
                    if (!visited.contains(nextNum)) {
                        queue.offer(nextNum);
                    }

                }
            }
            cnt++;
        }
        return -1;
    }

    public static LinkedList<String> getNextNums(char[] cArr) {
        LinkedList<String> nums = new LinkedList<>();
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            //9면 0으로 가는게 + 되는것, 0이면 9로 가는게 - 되는 것
            cArr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            nums.add(String.valueOf(cArr));
            cArr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            nums.add(String.valueOf(cArr));
            cArr[i] = c;
        }
        return nums;
    }

    public static void main(String[] args) {
        //TestCode
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[]{"8888"};
        System.out.println(solution(deadends, "0009"));
    }
}
