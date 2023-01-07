package java03linkedlist;
//Practice3
//원형 연결 리스트

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
        node.next = this.head; //원형이라 지정
        node.prev = this.head;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    //연결리스트에 데이터 추가
    //beforeData == null인경우 가장 뒤에 추가
    //beforeData에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            NodeBi newNodeBi = new NodeBi(data, null, null);
            this.head = newNodeBi;
            this.tail = newNodeBi;
            newNodeBi.next = newNodeBi;
            newNodeBi.prev = newNodeBi;
        } else if (beforeData == null) { //가장 끝노드에 추가
            NodeBi newNodeBi = new NodeBi(data, this.head, this.tail); //넥스트 = 헤드 , 이전 = tail (원형이라 처음을 가르키도록)
            this.tail.next = newNodeBi;
            this.head.prev = newNodeBi;
            this.tail = newNodeBi;
        } else { //비포데이터에 어떤 데이터가 들어왔을 때
            NodeBi cur = this.head;
            NodeBi pre = cur;
            do {
                if (cur.data == beforeData) {
                    if (cur == this.head) { //헤드에 추가
                        NodeBi newNodeBi = new NodeBi(data, this.head, this.tail); //원형 연결
                        this.tail.next = newNodeBi;
                        this.head.prev = newNodeBi;
                        this.head = newNodeBi;
                    } else { //노드가 중간에 추가되는 경우
                        NodeBi newNodeBi = new NodeBi(data, cur, pre);
                        pre.next = newNodeBi;
                        cur.prev = newNodeBi;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while (cur != this.head);
        }
    }

    //연결리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List it Empty");
            return;
        }
        NodeBi cur = this.head;
        NodeBi pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                //노드가 어디에 있는지, 하나뿐인지
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) { //처 음
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                } else if (cur == this.tail) { //끝
                    pre.next = this.tail.next;
                    this.tail = pre;
                    this.head.prev = this.tail;
                } else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }
    public void showData(){
        if (this.isEmpty()) {
            System.out.println("List it Empty");
            return;
        }
        NodeBi cur = this.head;
        while (cur.next != this.head){ //cur.next가 자기 자신이 되지 않을때까지 반복 ( 원형이니까 )
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println(cur.data); //가장끝노드 데이터
    }
}

public class Practice3 {
    public static void main(String[] args) {
        //TestCode
        CircularLinkedList myList = new CircularLinkedList(new NodeBi(1,null,null));

        myList.showData();

        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        System.out.println("myList.showData()");
        myList.showData();
        System.out.println();

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        System.out.println("myList.showData()");
        myList.showData();
        System.out.println();

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        System.out.println("myList.showData()");
        myList.showData();
        System.out.println();

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        System.out.println("myList.showData()");
        myList.showData();
        System.out.println();
    }
}
