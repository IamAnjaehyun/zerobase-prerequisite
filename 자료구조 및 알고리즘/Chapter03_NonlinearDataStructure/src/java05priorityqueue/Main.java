package java05priorityqueue;

import com.sun.jndi.ldap.sasl.LdapSasl;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

//비선형 자료구조 - 우선순위 큐
//연결 리스트를 이용한 우선순위 큐 (배열, 연결리스트, 힙 다있음, 연결리스트는 힙에 비해 효율적이진 못함)
//자바 기본 PriorityQueue -> 내부적으로 힙 자료구조로 되어있음
public class Main {
    public static void enqueue(LinkedList<Integer> list, int data){
        int idx = list.size(); //가장 끝 인덱스를 받아옴
        for (int i = 0; i < list.size(); i++) {
            //기존 리스트는 정렬 리스트
            if(list.get(i) > data){ //앞부터 순회해서, 기존의 리스트는 정렬된 연결리스트라 앞쪽이 값이 더 작아서 맨앞만 비교 해당되면 인덱스 업데이트
                idx = i;
                break;
            }
        }
        list.add(idx, data);
    }
    public static Integer dequeue(LinkedList<Integer> list){
        //이미 정렬되어있고 우선순위 큐임 가장 앞에있는 데이터만 꺼내면 됨
        if(list.size() == 0){
            return null;
        }

        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args){
        //연결리스트를 이용한 우선순위 큐
        System.out.println("== 연결리스트 방식의 우선순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList<>();
        enqueue(pqList,5);
        enqueue(pqList,7);
        enqueue(pqList,3);
        enqueue(pqList,1);
        enqueue(pqList,9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);
        System.out.println();

        //자바 기본 PriorityQueue 사용
        System.out.println("== 자바 기본 우선순위 큐(PriorityQueue) ==");
        //우선순위 : 낮은 숫자 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(9);
        System.out.println(Arrays.toString(pq.toArray()));


        //우선순위 : 높은 숫자 순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(9);
        System.out.println(Arrays.toString(pq2.toArray()));


    }
}
