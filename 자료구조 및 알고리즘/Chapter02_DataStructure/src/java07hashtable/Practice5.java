package java07hashtable;


//Practice5
//해시 충돌 해결 - 분리 연결
class Node{
    int key;
    int data;
    Node next;

    Node(int key, int data, Node next){
        this.key=key;
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
    }

    LinkedList(Node node) {
        this.head = node;
    }


    //연결리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    //연결리스트의 맨 뒤의 데이터 추가
    public void addData(int key, int data) {
        //연결리스트에 아무런 노드도 없을 때
        if (this.head == null) { //헤드가 널이면 헤드쪽에 노드 생성,맨처음 헤드 생성할때 data 넣어줌
            this.head = new Node(key, data, null); //헤드가 널이니까 뒤에는 null 한걸 head에 넣어줌
        } else { //노드가 있으면 헤드로부터 노드들을 하나씩 순회하면서 끝까지 도달시킴
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(key, data, null); //가장 끝에 노드를 만들어서 추가시켜줌
        }
    }

    //연결리스트의 맨 뒤의 데이터 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;

        while (cur != null){
            if(cur.key == data){
                if(cur == this.head){
                    this.head = cur.next;
                }else{
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }

    }

    //연결리스트에서 데이터 찾기
    public Integer findData(int data){
        if(this.isEmpty()){
            System.out.println("List it empty");
            return null;
        }

        Node cur = this.head;
        while(cur != null){//cur 이동시키면서 data찾음
            if(cur.key == data){ //데이터 있으며 리턴
                System.out.println("Data exist");
                return cur.data;
            }
            cur=cur.next;
        }
        System.out.println("Data Not Found!"); //못찾으면 없다 출력
        return null;
    }

    //연결리스트의 모든 데이터 출력
    public void showData(){
        if(this.isEmpty()){
            System.out.println("List it empty");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class MyHashTable5{
    LinkedList[] table;

    MyHashTable5(int size){
        this.table = new LinkedList[size];
        for(int i =0; i<this.table.length; i++){
            this.table[i] = new LinkedList(null);
        }
    }

    public int getHash(int key){
        return key % this.table.length;
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        this.table[idx].addData(key,data);
    }

    public int getValue(int key){
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }

    public void removeValue(int key){
        int idx = this.getHash(key);

        this.table[idx].removeData(key);
    }

    public void printHashTable(){
        System.out.println("==Hash Table==");
        for(int i=0;i<this.table.length;i++){
            System.out.print(i +" : ");
            this.table[i].showData();
        }
    }
}

public class Practice5 {
    public static void main(String[] args) {
        //TestCode
        MyHashTable5 ht = new MyHashTable5(11);
        ht.setValue(1,10);
        ht.setValue(2,20);
        ht.setValue(3,30);
        ht.printHashTable();
        ht.setValue(12,11);
        ht.setValue(23,12);
        ht.setValue(34,13);

        ht.setValue(13,21);
        ht.setValue(24,22);
        ht.setValue(35,23);

        ht.setValue(5,1);
        ht.setValue(16,2);
        ht.setValue(27,3);
        ht.printHashTable();

        System.out.println("==key 값으로 해당 데이터 가져오기==");
        System.out.println(ht.getValue(1));
        System.out.println(ht.getValue(12));

        System.out.println("==데이터 삭제==");
        ht.removeValue(1);
        ht.removeValue(5);
        ht.removeValue(16);
        ht.printHashTable();
    }
}
