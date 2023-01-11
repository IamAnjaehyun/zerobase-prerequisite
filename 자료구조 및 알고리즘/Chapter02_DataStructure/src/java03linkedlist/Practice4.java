package java03linkedlist;
//Practice4.md
//단방향 연결리스트에서 중복 데이터를 찾아 삭제하세요

//입출력 예시)
//입력 연결 리스트 : 1,3,3,1,4,2,4,2,
//결과 연결 리스트 : 1,3,4,2

//Main에 있는 Node 사용
class LinkedList4 {
    Node head;

    LinkedList4() {
    }

    LinkedList4(Node node) {
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
    public void addData(int data) {
        //연결리스트에 아무런 노드도 없을 때
        if (this.head == null) { //헤드가 널이면 헤드쪽에 노드 생성,맨처음 헤드 생성할때 data 넣어줌
            this.head = new Node(data, null); //헤드가 널이니까 뒤에는 null 한걸 head에 넣어줌
        } else { //노드가 있으면 헤드로부터 노드들을 하나씩 순회하면서 끝까지 도달시킴
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null); //가장 끝에 노드를 만들어서 추가시켜줌
        }
    }

    //연결리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while (cur.next != null) {//cur은 이동
            prev = cur; //이동 전 cur을 prev가 받음
            cur = cur.next; // cur 이동하면서 그 자리를 prev가 받음
        }

        if (cur == this.head) { //cur 결과가 head면 null로 바꾸면 됨
            this.head = null;
        } else {
            prev.next = null; //아니면 prev.next를 null로
        }

    }

    //연결리스트에서 데이터 찾기
    public boolean findData(int data){
        if(this.isEmpty()){
            System.out.println("List is empty");
        }

        Node cur = this.head;
        while(cur != null){//cur 이동시키면서 data찾음
            if(cur.data == data){ //데이터 있으며 리턴
//                System.out.println("Data exist");
                return true;
            }
            cur=cur.next;
        }
//        System.out.println("Data Not Found!"); //못찾으면 없다 출력
        return false;
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




public class Practice4 {
    private static LinkedList4 removeDup(LinkedList4 listBefore) {
        LinkedList4 listAfter = new LinkedList4();//새로 리스트 만들어서 데이터 넣을때 검증

        Node cur = listBefore.head;
        while (cur != null){
            if(listAfter.findData(cur.data) == false){ //맨처음엔 비어있는 배열이라 List is E
                listAfter.addData(cur.data);
            }
            cur = cur.next;
        }
        return listAfter;
    }

    public static void main(String[] args) {
        //TestCode
        LinkedList4 linkedList = new LinkedList4();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.showData();

        linkedList = removeDup(linkedList);
        linkedList.showData();
    }

}
