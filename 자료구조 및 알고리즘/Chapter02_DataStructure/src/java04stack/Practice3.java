package java04stack;

//문자열 뒤집기
//입력 : "Hello"
//출력 : "olleH"

//입력 : 1 3 5 7 9
//출력 : 9 7 5 3 1

import java.util.Stack;

public class Practice3 {
    public static String reverseString(String str) {
        String result = "";
        Stack myStack = new Stack();

        for (String s : str.split("")) {
            myStack.push(s);
        }
        while(!myStack.isEmpty()){
            result += myStack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        //TestCode
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);

    }
}
