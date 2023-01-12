package java08practice;

import java.util.Hashtable;

//동명이인 처리 해야함
public class Practice9 {

    public static String solution(String[] participant, String[] completion) {

        String result = "";
        Hashtable<String, Integer> ht = new Hashtable<>(); //사람이름, 명수

        for (String item : participant) {
            if (ht.containsKey(item)) {
                ht.put(item, ht.get(item) + 1);
            } else {
                ht.put(item, 1);
            }
        }

        for (String item : completion) {
            ht.put(item, ht.get(item) - 1);
        }

        for (String item : participant) {
            if (ht.get(item) > 0) {
                result = item;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "marina", "nikola", "filipa"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));


    }

}
