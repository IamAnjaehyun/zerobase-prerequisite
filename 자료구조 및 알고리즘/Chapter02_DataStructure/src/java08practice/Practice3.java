package java08practice;

//원형 연결 작업을 위해 만든 Node, LinkedList
class Node {
    int data; //풍선의 번호
    int cmd; //풍선안에 뭐가들어있는지

    boolean visited; //풍선 터졌는지

    Node next;
    Node prev;

    public Node(int data, int cmd, boolean visited, Node next, Node prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedListC {
    Node head;

    public void add(int data, int cmd) {
        if (this.head == null) {
            this.head = new Node(data, cmd, false, null, null);
            this.head.next = this.head;
            this.head.prev = this.head;
        } else {
            Node cur = this.head;
            while (cur.next != this.head) {
                cur = cur.next;
            }
            cur.next = new Node(data, cmd, false, cur.next, cur);
            this.head.prev = cur.next;
        }
    }
}

public class Practice3 {
    public static void solution(int[] data) {
        LinkedListC linkedList = new LinkedListC();
        for (int i = 0; i < data.length; i++) {
            linkedList.add(i + 1, data[i]); //풍선 번호는 1번부터
        }
        Node cur = linkedList.head;
        int visitCnt = 0;
        int cmd = 0;
        while (visitCnt != data.length) { //풍선개수만큼 돌아야되니까
            int cnt = 0;
            while (cnt != Math.abs(cmd)) { //풍선안에 -숫자도 들어있음
                if (cmd > 0) {
                    cur = cur.next;
                }else{
                    cur = cur.prev;
                }
                if(cur.visited == false){
                    cnt++;
                }

            }
            System.out.print(cur.data + " "); //터진풍선
            cur.visited = true; //터짐
            visitCnt++;
            cmd = cur.cmd; //터트린 풍선의 cmd 갱신(위치)
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
