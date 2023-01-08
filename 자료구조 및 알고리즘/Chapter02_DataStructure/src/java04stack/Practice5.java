package java04stack;

//Practice5
//후위 표기법 연산
//참고 설명 ) 전위 "+ 1 1" /중위 "1 + 1" /후위 표기법 "2 2 +"
//ex) 중위 > 후위 (1+2)X3 -> ((1+2)X3) -> 12+3X
//ex) 중위 > 후위 1+2X3 -> 1+(2X3) -> (1+(2X3)) -> 123X+ (괄호 맨뒤로 연산자를 보내버림)


//입출력 예시)
//입력: "2 2 +"
//출력: 4

//입력: "2 2 -"
//출력: 0

import java.util.Stack;

public class Practice5 {
    public static double calculate(String string) {
        Stack<Double> stack = new Stack();
        for (String str : string.split(" ")) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(calculate("2 2 +"));
        System.out.println(calculate("2 2 -"));
        System.out.println(calculate("2 2 *"));
        System.out.println(calculate("2 2 /"));

        System.out.println(calculate("2 2 + 2 * 3 * 2 / 5 -"));
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));
    }
}
