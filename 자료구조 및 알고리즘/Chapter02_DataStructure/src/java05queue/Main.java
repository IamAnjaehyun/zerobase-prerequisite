package java05queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new LinkedList(); //queue는 인터페이스라 다형성을 이용해서 linkedlist 사용해야함

//        Stack stack = new Stack(); //스택은 바로 쓸 수 있음

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.size());
        System.out.println(queue.contains(3));
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll()); //null이라 안나옴





    }
}
