package java04stack;

//Practice2
//배열을 이용한 기본 스택 직접 구현
class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.top == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        if (this.isFull()) {
            System.out.println("Stack is Full");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data;

    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }

        int data = this.arr[this.top];
        this.top -= 1; //데이터가 남아있긴 한데 top에서 관리
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }

        return this.arr[this.top];
    }

    public void printStack() {
        for (int i = 0; i < this.top-1; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }


}

public class Practice2 {
    public static void main(String[] args) {
        MyStack2 myStack = new MyStack2(5);
        System.out.println("myStack.isEmpty() : "+myStack.isEmpty());

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
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
