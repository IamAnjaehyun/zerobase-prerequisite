package java06deque;

import java.util.ArrayDeque;
import java.util.Deque;

//선형 자료구조 데크
public class Main {
    public static void main(String[] args) {
        //양방향 구조
        Deque deque = new ArrayDeque();

        //Front 부분 입력 (왼쪽에서 오른쪽)
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);

        //Rear 부분 입력 (오른쪽에서 왼쪽)
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);

        //Front 부분 입력
        deque.removeFirst();
        System.out.println(deque);

        //Rear 부분 입력
        deque.removeLast();
        System.out.println(deque);


        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println("pollLast:" + deque.pollLast());
        try {
            System.out.println("removeLast:" + deque.removeLast());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
