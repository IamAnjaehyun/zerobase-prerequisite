package java03linkedlist;

// Practice2
// 양방향 연결리스트 (Doubly Linked List) 구현
class NodeBi {
    int data;
    NodeBi next;
    NodeBi prev;

    public NodeBi(int data, NodeBi next, NodeBi prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedList {
    NodeBi head;
    NodeBi tail;

    public DoublyLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        } else if (beforeData == null) {
            this.tail.next = new NodeBi(data, null, this.tail);
            this.tail = this.tail.next;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new NodeBi(data, this.head, null);
                        this.head.next.prev = this.head;
                    } else {
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }
        public void removeData ( int data){
            if (this.isEmpty()) {
                System.out.println("List is Empty");
                return;
            }

            NodeBi cur = this.head;
            NodeBi pre = cur;
            while (cur != null) {
                if (cur.data == data) {
                    if (cur == this.head && cur == this.tail) { //노드가 하나인 케이스 지우면 다 null
                        this.head = null;
                        this.tail = null;
                    } else if (cur == this.head) { //head인 경우 head 다음으로 넘기고 이전을 null처리하면 뒤에꺼 사라짐
                        this.head = cur.next;
                        this.head.prev = null;
                    } else if (cur == this.tail) { //가장 끝인 경우 기존 테일을 이전tail 이전 넥스트를 null 처리
                        this.tail = this.tail.prev;
                        this.tail.next = null;
                    } else { //중간노드 삭제 cur.next -> pre.next / cur.next.이전은 pre
                        pre.next = cur.next;
                        cur.next.prev = pre;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }

        public void showData () {
            if (this.isEmpty()) {
                System.out.println("List it Empty");
                return;
            }
            NodeBi cur = this.head;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }

        public void showDataFromTail () {
            if (this.isEmpty()) {
                System.out.println("List it Empty");
                return;
            }
            NodeBi cur = this.tail;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.prev;
            }
            System.out.println();
        }
    }

    public class Practice2 {
        public static void main(String[] args) {
            //Test code
            DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
            myList.showData();

            myList.addData(2, null);
            myList.addData(3, null);
            myList.addData(4, null);
            myList.addData(5, null);
            System.out.println("myList.showData()");
            myList.showData();
            System.out.println();
            System.out.println("myList.showDataFromTail()");
            myList.showDataFromTail();
            System.out.println();

            myList.addData(100, 1);
            myList.addData(200, 2);
            myList.addData(300, 3);
            myList.addData(400, 4);
            myList.addData(500, 5);
            System.out.println("myList.showData()");
            myList.showData();
            System.out.println();
            System.out.println("myList.showDataFromTail()");
            myList.showDataFromTail();
            System.out.println();

            myList.removeData(300);
            myList.removeData(100);
            myList.removeData(500);
            myList.removeData(200);
            myList.removeData(400);
            System.out.println("myList.showData()");
            myList.showData();
            System.out.println();
            System.out.println("myList.showDataFromTail()");
            myList.showDataFromTail();
            System.out.println();

            myList.removeData(3);
            myList.removeData(1);
            myList.removeData(5);
            myList.removeData(2);
            myList.removeData(4);
            System.out.println("myList.showData()");
            myList.showData();
            System.out.println();
            System.out.println("myList.showDataFromTail()");
            myList.showDataFromTail();
            System.out.println();
        }
    }
