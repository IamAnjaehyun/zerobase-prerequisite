package java06deque;
//Practice4
//팰린드롬(Palindrome) 찾기 (뒤집어도 똑같은 문자열)

// 입력 a
// 결과 true

// 입력 madam
// 결과 true

import java.util.ArrayDeque;
import java.util.Deque;

// 입력 abab
// 결과 false
public class Practice4 {
    public static boolean checkPalindrome(String str) {
        Deque deque = new ArrayDeque();
        boolean isFront = true;
        boolean isPalindrome = true;

        for (String x : str.split("")) {
            deque.addLast(x);
        }

        while (!deque.isEmpty()) {
            String s1 = (String)deque.pollLast();
            String s2 = (String)deque.pollFirst();

            if(s1 != null && s2 != null && !s1.equals(s2)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }



    public static void main(String[] args) {

        //TestCode
        System.out.println(checkPalindrome("a"));
        System.out.println(checkPalindrome("aba"));
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome("abab"));
        System.out.println(checkPalindrome("abcba"));
        System.out.println(checkPalindrome("abccba"));
        System.out.println(checkPalindrome("madam"));
    }

}
