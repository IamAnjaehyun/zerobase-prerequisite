package java05queue;
//Practice
//ArrayList 를 이용한 큐 구현

import java.util.ArrayList;

class MyQueue1 {
    ArrayList list;

    MyQueue1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        }else{
            return false;
        }
    }

    public void push(int data){
        this.list.add(data);
    }

    public Integer pop(){
        if(this.isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        int data = (int)this.list.get(0); // 0을 입력하면 처음에 있는걸 꺼내감
        this.list.remove(0);
        return data;
    }

    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return  (int)this.list.get(0); // 0을 입력하면 처음에 있는걸 꺼내감
    }

    public void printQueue(){
        System.out.println(this.list);
    }

}

public class Practice1 {
    public static void main(String[] args) {
    //TestCode
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);

        myQueue.printQueue();

        System.out.println(myQueue.peek());
        myQueue.printQueue();

        System.out.println(myQueue.pop());
        myQueue.printQueue();

        System.out.println(myQueue.pop());
        myQueue.printQueue();

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        myQueue.printQueue();

    }

}
