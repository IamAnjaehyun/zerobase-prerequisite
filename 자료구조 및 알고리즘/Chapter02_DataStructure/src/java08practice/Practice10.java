package java08practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.stream.Stream;

//2중 ArrayList<ArrayList<Integer>>
//aList라는 ArrayList 형 상자 안에, a1이라는 ArrayList형 상자, a2라는 ArrayList형 상자가 있다고 생각하자.
//그리고 a1 상자안에는상자 안에는 1,2가 저장되어있고, a2 상자 안에는 3이 저장되어있다.
//그래서  1 2 를  꺼내는 방법은 바깥에서부터 순차적으로 aList.get() 한 뒤, 또 get()메소드를 사용해 출력하면 된다.
public class Practice10 {
    public static ArrayList<Integer> solution(String[] gems) {
        //구매구간 넣어서 가장 짧은 구간 출력 예정
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        Stream.of(gems).forEach(x -> set.add(x));
        int n = set.size(); //보석 종류 개수

        if (n == 1) {
            result.add(new ArrayList<>(Arrays.asList(1, 1)));
            return result.get(0);
        }

        Hashtable<String, Integer> ht = new Hashtable<>(); //보석 , 개수 위한  ht
        boolean isCandidate = false;

        int left = 0;
        int right = 0;

        ht.put(gems[0], 1);

        while (true) {
            if (isCandidate == false) {
                right += 1;
                if (right >= gems.length) { //보석 더이상 없음
                    break;
                }

                if (ht.containsKey(gems[right]) == false) {//등장한 보석이 ht에 없음
                    ht.put(gems[right], 1);
                } else {
                    ht.put(gems[right], ht.get(gems[right]) + 1);
                }

                if (ht.size() == n) { //모든 보석의 종류가 테이블 안에 있음
                    isCandidate = true;
                    result.add(new ArrayList<>(Arrays.asList(left + 1, right + 1)));//현재 구간 넣어줌
                }
            } else {
                left += 1;
                int cnt = ht.get(gems[left - 1]) - 1; //하나뺐는데

                if (cnt == 0) { //해당 보석을 못삼(한종류 못삼)
                    ht.remove(gems[left - 1]);
                    isCandidate = false;
                } else { //보석 뺐는데도 cnt 0 아니면 보석 다 살수 있는거니 현재구간 추가해줌
                    ht.put(gems[left - 1], cnt);
                    result.add(new ArrayList<>(Arrays.asList(left + 1, right + 1)));
                }
            }

        }
        //가장 짧은 구간 찾기
        int minIdx = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) { //result에 구간 들어있음
            ArrayList<Integer> cur = result.get(i);
            left = cur.get(0);
            right = cur.get(1);

            if (right - left < minNum) { //구간 간격의 크기가 더 작으면 갱신
                minNum = right - left;
                minIdx = i;
            }
        }
        return result.get(minIdx);
    }

    public static void main(String[] args) {
        //TestCode
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(solution(gems));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(solution(gems));

    }
}
