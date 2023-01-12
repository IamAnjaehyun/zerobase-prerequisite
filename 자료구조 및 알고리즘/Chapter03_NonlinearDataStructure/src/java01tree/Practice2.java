package java01tree;

//Practice2
//연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2 {
    Node head;

    public BinaryTree2() {
    }

    public BinaryTree2(char[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i], null, null);
        }
        //현재 노드에 대해 자식 노드들을 연결
        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            //왼쪽 노드
            if (left < arr.length) {
                nodes[i].left = nodes[left];
            }
            //오른쪽 노드
            if (right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }
        //맨 처음 루트 노드에 대한 연결
        this.head = nodes[0];
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    //Queue 구조 사용 A 넣고 A출력 > A의자식 검사해서 A자식(BC) Queue에 넣음 B자식(DE) 검사하고 Queue에 넣고 C 출력 C자식(FG) 검사 ...
    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.offer(cur.left); //offer = 값 추가 후 값 리턴
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

}

public class Practice2 {
    public static void main(String[] args) {
        //TestCode
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("==PreOrder==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("==InOrder==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("==PostOrder==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("==PostOrder==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
