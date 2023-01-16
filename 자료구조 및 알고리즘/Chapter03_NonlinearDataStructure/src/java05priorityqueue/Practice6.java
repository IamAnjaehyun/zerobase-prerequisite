package java05priorityqueue;
//Practice6
//문자열 s가 주어졌을 때, 문자열 내에 동일한 알파벳이 연속적으로 배치되지 않도록 재배치 하시오.
//재배치가 가능한 경우 재정렬한 문자열을 반환하고, 불가능한 경우 null을 반환하세요.

//입출력 예시
//입력 : "aabb"
//출력 : "abab"

//입력 : "aaca"
//출력 : null

/*
for (Map.Entry<String, String> book: bookMap.entrySet()) {
    System.out.println("key: " + book.getKey() + " value: " + book.getValue());}
Map.Entry : Map의 키와 값을 모두 가져올때 편리
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class Practice6 {
    public static String solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();//빈도수 세기
        for (String item : s.split("")) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            pq.offer(item);
        }

        StringBuffer sb = new StringBuffer();
        Map.Entry<String, Integer> prev = null;
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> cur = pq.poll();

            if (prev != null && prev.getValue() > 0) { //꺼냈다 바로 넣지 않고 다음 데이터 확인할 때 남아있으면 넣는 이부분이 핵심
                pq.offer(prev);
            }

            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);

            prev = cur;
            if (pq.isEmpty() && prev.getValue() > 0) {
                return null;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(solution("aabb"));
        System.out.println(solution("aaaaabccd"));
        System.out.println(solution("aaca"));
    }
}
