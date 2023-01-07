package java03linkedlist;

//Practice1
//단순 연결 리스트 구현 완성

class LinkedList2 extends LinkedList {
    LinkedList2(Node node) {
        super.head = node; //부모클래스에서 온 멤버 변수 할당
    }

    //연결리스트에 데이터 추가
    //Before_data == null > 가장 뒤에 추가
    //Before_data == exist > 해당 값을 가진 노드 앞에 추가

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) { //beforeData ==  null이면 가장 뒤에 추가할거임
            Node cur = this.head; // head로부터 반복문 돌림 넥스트 없을 때 까지
            while (cur.next != null) {
                cur = cur.next; //가장 끝 노드
            }
            cur.next = new Node(data, null); // 가장 끝 노드에 데이터로 만들어서 할당
        } else {
            Node cur = this.head;
            Node pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) { //연결리스트에서 beforeData 값 찾으면 그 앞에 추가
                    if (cur == this.head) {
                        this.head = new Node(data, this.head); // 다음 노드는 이전 헤드 노드
                    } else {
                        pre.next = new Node(data, cur); //중간에 들어가면 다음 노드는 cur
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data) { //끝에서만 지우는게 아님 앞,중간,뒤 다 가능
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null){
            if(cur.data == data){
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
}

public class Practice1 {
    public static void main(String[] args) {
        //Test code
        LinkedList2 myList = new LinkedList2(new Node(1,null));
        myList.showData();
        System.out.println();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        System.out.println("myList.showData()");
        myList.showData();
        System.out.println();

        myList.addData(100,1);
        myList.addData(200,2);
        myList.addData(300,3);
        myList.addData(400,4);
        myList.addData(500,5);
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
