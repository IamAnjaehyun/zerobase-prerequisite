package java04stack;
//Practice4.md
//괄호 짝 검사

//입출력 예시
//입력 : "("
//출력 : Fail

//입력 : ")"
//출력 : True

//입력 : "()"
//출력 : Pass

import java.util.Stack;

public class Practice4 {
    public static void checkParenthesis(String str) {
        Stack myStack = new Stack();
        boolean checkFlag = true;
        for (String s : str.split("")) {
            if (s.equals("(")) {
                myStack.push(s);
            } else {
                if (myStack.isEmpty()) {
                    checkFlag = false;
                    break;
                }else{
                    myStack.pop();
                }
            }
        }
        if(checkFlag && myStack.isEmpty()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }

    public static void main(String[] args) {
        //TestCode
        checkParenthesis("(");
        checkParenthesis(")");
        checkParenthesis("()");
        checkParenthesis("()()()");
        checkParenthesis("(())()");
        checkParenthesis("(((()))");
    }
}
