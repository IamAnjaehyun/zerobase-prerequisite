package java06devideandconquer;
//Practice2
//2차원 정수형 배열 lists가 주어졌다.
//list[i] 에는 각 LinkedList의 원소 정보가 들어 있고,
//원소들은 오름차순 정렬된 상태이다.
//모든 LinkedList를 하나의 정렬된 LinkedList로 합병하세요.

//입출력 예시
//lists : {{2,3,9},{1,5,7},{3,6,7,11}}
//출력 : 1 > 2 > 3 > 3 > 5 > 6 > 7 > 7 > 9 > 11

import com.sun.org.apache.bcel.internal.generic.NOP;
import javafx.beans.binding.When;
import jdk.nashorn.internal.ir.WhileNode;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Practice2 {

    public static Node solution(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divideList(lists, 0, lists.length - 1);
    }

    public static Node divideList(Node[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        Node l1 = divideList(lists, left, mid); //왼쪽
        Node l2 = divideList(lists, mid + 1, right); //오른쪽

        return mergeList(l1, l2);
    }

    private static Node mergeList(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Node merge = new Node(0);
        Node cur = merge;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }//길이가 다른경우 하나는 남아있음
        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return merge.next;
    }

    //문제에 주어진 2차원 배열을 LinkedList로 구성
    public static void setUpLinkedList(Node[] node, int[][] lists) {
        for (int i = 0; i < lists.length; i++) {
            node[i] = new Node(lists[i][0]);
        }

        for (int i = 0; i < lists.length; i++) {
            Node cur = node[i];
            for (int j = 1; j < lists[i].length; j++) {
                cur.next = new Node(lists[i][j]);
                cur = cur.next;
            }
        }
    }

    //결과 출력 부분
    public static void printList(Node node) {
        Node cur = node;
        while (cur.next != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public static void main(String[] args) {
        //TestCode
        int[][] lists = {{2, 3, 9}, {1, 5, 7}, {3, 6, 7, 11}};
        Node[] node = new Node[lists.length];
        setUpLinkedList(node, lists);
        Node combineNode = solution(node);
        printList(combineNode);
    }

}
