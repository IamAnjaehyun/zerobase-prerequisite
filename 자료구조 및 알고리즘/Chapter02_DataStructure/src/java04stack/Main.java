package java04stack;

import java.util.Stack;

//선형 자료구조 - 스택
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        System.out.println("stack.pop() : " + stack.pop());
        System.out.println("pop 하고 남은 stack : " + stack);

        stack.pop();
        System.out.println("pop 하고 남은 stack : " + stack);

        System.out.println("마지막 자료만 보여주는 stack.peek() : " + stack.peek());
        System.out.println("peek 하고 남은 stack : " + stack);

        System.out.println("stack.contains(1) : " + stack.contains(1));
        System.out.println("stack.size() : " + stack.size());
        System.out.println("stack.empty() : " + stack.empty());

        stack.clear();
        System.out.println("stack.clear 하고 난 후 : " + stack);

        System.out.println("clear 하고 난 후 stack.pop() : " + stack.pop());

    }
}
