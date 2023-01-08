package java04stack;
//Practice6
//두 문자열 비교
//단, #은 backspace로 바로 이전의 문자를 삭제하는 기능이라고 가정

//입출력 예시
//입력 : s1 = "tree", s2 = "th#ree"
//출력 : true

//입력 : s1 = "ab#a", s2 = "aab#"
//출력 : true

import java.util.Stack;

//입력 : s1 = "wo#w", s2 = ww#o"
//출력 : false
public class Practice6 {
    public static boolean stringCompare(String s1, String s2){
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        for(String s : s1.split("")){
            if(s.equals("#")){stack1.pop();}
            else{stack1.push(s);}
        }

        for(String s : s2.split("")){
            if(s.equals("#")){stack2.pop();}
            else{stack2.push(s);}
        }
        return stack1.equals(stack2);
    }

    public static void main(String[] args) {
        //TestCode
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1,s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1,s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1,s2));
    }
}
