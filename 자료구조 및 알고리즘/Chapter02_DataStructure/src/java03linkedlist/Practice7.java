package java03linkedlist;
//Practice4
//연결 리스트 배열 사용 연습

//주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성하시오.
//관리 규칙은 다음과 같다.
//각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기

import java.util.HashSet;

class Node7 {
    String data;
    Node7 next; //여러 노드 중 다음 노드를 가리키는 역할로 사용

    Node7() {
    }

    Node7(String data, Node7 next) {
        this.data = data;
        this.next = next;

    }
}

class LinkedList7 {
    Node7 head;
    char alphabet;

    LinkedList7() {
    }

    LinkedList7(Node7 node, char alphabet) {
        this.head = node;
        this.alphabet = alphabet;
    }


    //연결리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    //연결리스트의 맨 뒤의 데이터 추가
    public void addData(String data) {
        //연결리스트에 아무런 노드도 없을 때
        if (this.head == null) { //헤드가 널이면 헤드쪽에 노드 생성,맨처음 헤드 생성할때 data 넣어줌
            this.head = new Node7(data, null); //헤드가 널이니까 뒤에는 null 한걸 head에 넣어줌
        } else { //노드가 있으면 헤드로부터 노드들을 하나씩 순회하면서 끝까지 도달시킴
            Node7 cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node7(data, null); //가장 끝에 노드를 만들어서 추가시켜줌
        }
    }

    //연결리스트의 맨 뒤의 데이터 삭제
    public void removeData(String data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node7 cur = this.head;
        Node7 pre = cur;

        while (cur.next != null) {//cur은 이동
            if (cur.data.equals(data)) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    //연결리스트에서 데이터 찾기
    public boolean findData(String data) {
        if (this.isEmpty()) {
            System.out.println("List it empty");
        }

        Node7 cur = this.head;
        while (cur != null) {//cur 이동시키면서 data찾음
            if (cur.data.equals(data)) { //데이터 있으며 리턴
                System.out.println("Data exist");
                return true;
            }
            cur = cur.next;
        }
        System.out.println("Data Not Found!"); //못찾으면 없다 출력
        return false;
    }

    //연결리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List it empty");
            return;
        }
        Node7 cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}


public class Practice7 {
    public static void dataCollect(String[] data) {
        HashSet<Character> set = new HashSet<>();

        for(String item : data){
            set.add(item.toCharArray()[0]); //첫글자 set에 넣음 (HashSet이라 중복 안들어감)
        }
        System.out.println(set);

        Character[] arr = set.toArray(new Character[0]);
        LinkedList7[] linkedList = new LinkedList7[set.size()]; //공간만 만든거고 객체 할당된건 아님
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkedList7(null, arr[i]); //각각의 위치에 객체를 만듬 head는 null 각 위치에는 알파벳 첫글자
        }

        for(String item : data){
            for(LinkedList7 list : linkedList){
                if(list.alphabet == item.toCharArray()[0]){
                    list.addData(item);
                }
            }
        }
        for(LinkedList7 list : linkedList){
            System.out.print(list.alphabet + " : ");
            list.showData();
        }
    }

    public static void main(String[] args) {
        //TestCode
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry", "orange", "cherry"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", "crab", "kitten", "anaconda", "chicken"};
        dataCollect(input2);
    }
}
