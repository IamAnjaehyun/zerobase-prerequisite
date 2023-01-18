package java02sort;
//Practice2
//문자열 배열 strs가 주어졌을 때 anagram으로 묶어서 출력하는 프로그램을 작성하세요.
//anagram은 철자 순서를 바꾸면 같아지는 문자를 의미한다.
//ex) elvis <-> lives
//anagram 그룹 내에서 출력 순서는 상관 없다.

import java.util.ArrayList;
import java.util.HashMap;

//입출력 예시
//입력 : "eat","tea","tan","ate","nat","bat"
//출력 : [[eat, tea, ate], [bat], [tan, nat]]
public class Practice2 {
    public static ArrayList<ArrayList<String>> solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cArr = s.toCharArray();
            //sort
            sort(cArr);
            String key = String.valueOf(cArr); //다시 스트링으로 변환


            if(!map.containsKey(key)){ //얘에 대한 데이터가 들어있지 않으면
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(s); //이미 해당하는 키값에 대한 데이터가 들어있으면 anagram

        }
        return new ArrayList<>(map.values());
    }

    //복습차원 삽입정렬
    public static void sort(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        //TestCode
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        System.out.println(solution(strs));

    }
}
