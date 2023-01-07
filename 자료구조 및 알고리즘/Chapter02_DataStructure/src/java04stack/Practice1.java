package java04stack;
//Practice1
//ArrayList 를 이용한 스택 구현

import java.util.ArrayList;

class MyStack1 {
    ArrayList list;

    MyStack1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) { //맨뒤에 더하기
        this.list.add(data);
    }

    public Integer pop() { //마지막꺼 빼버림
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        int data = (int) this.list.get(this.list.size() - 1);// 최대사이즈 인덱스 -1을 뽑아줌
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public Integer peek() { //마지막꺼 출력만
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        int data = (int) this.list.get(this.list.size() - 1);// 최대사이즈 인덱스 -1을 뽑아줌

        return data;
    }

    public void printStack() {
        System.out.println(this.list);
    }
}

public class Practice1 {
    public static void main(String[] args) {
        //TestCode
        MyStack1 myStack = new MyStack1();

        System.out.println("myStack.isEmpty() : " + myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.printStack();

        System.out.println(myStack.peek());
        myStack.printStack();

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack();

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack();
    }
}
