package Java_18_2.src;

import java.util.ArrayList;

public class Practice3 {
    public static String solution(String input, String cmd) {
        StringBuffer sb = new StringBuffer(input); //문자열이 자주 바뀔때 유용함
        ArrayList<String> cmdArr = new ArrayList<>();

        for (String s : cmd.split(" ")) {
            cmdArr.add(s);
        }

        int curSor = sb.length(); //맨끝이 커서위치
        int cmdIdx = 0;
        while (cmdIdx != cmdArr.size()) { //가장 끝에있는 커맨드 실행할때까지
            String cur = cmdArr.get(cmdIdx); //명령어 하나씩 꺼내기
            if (cur.equals("L")) {
                curSor = Math.max(0, curSor - 1); //음수로 가면 안되니 적어도 0은 보장
            } else if (cur.equals("D")) {
                curSor = Math.min(sb.length(), curSor + 1); //문자열 넘어가면 안되니 끝거리는 len
            } else if (cur.equals("B")) {
                if (curSor == 0) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor - 1, curSor); //좌측 한 데이터 지우기
                curSor = Math.max(0, curSor -1);
            } else if (cur.equals("P")) {
                String s = cmdArr.get(++cmdIdx);
                sb.insert(curSor, s); //커서에 꺼낸거 위치해줌
                curSor += 1;
            }
            cmdIdx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
