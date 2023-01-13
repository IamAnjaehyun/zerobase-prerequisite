package java02binarysearchtree;
//비선형 자료구조 - 이진 탐색 트리


import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key) {
        if (this.head == null) {
            this.head = new Node(key, null, null);
        } else { //노드 있으면 순회하면서 왼쪽 오른쪽 어디로 갈지
            Node cur = this.head;

            while (true) {
                Node pre = cur;

                if (key < cur.key) { //추가하려는 키값 < 부모의 키값
                    cur = cur.left;

                    if (cur == null) { //해당부분이 비어있으면
                        pre.left = new Node(key, null, null); //왼쪽에 추가
                        break;
                    }
                } else { //추가하려는 키값 > 부모의 키값
                    cur = cur.right;
                    if (cur == null) {
                        pre.right = new Node(key, null, null); //오른쪽에 추가
                        break;
                    }
                }
            }
        }
    }

    public void removeNode(int key) {
        Node parent = null; // 부모 노드
        Node successor = null; // 지우려는 대상에 노드에 올려야하는 후계자 노드
        Node predecessor = null; // successor 의 부
        Node child = null; //자식 노드

        Node cur = this.head;
        //들어온 key의 위치 찾기
        while (cur != null) {
            if (key == cur.key) {
                break;
            }

            parent = cur;
            if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (cur == null) {
            System.out.println("key에 해당하는 노드가 없습니다.");
            return;
        }
        //leaf노드인 경우
        if (cur.left == null && cur.right == null) {
            if (parent == null) {
                this.head = null;
            } else {
                if (parent.left == cur) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (cur.left != null && cur.right == null || cur.left == null && cur.right != null) { //자식 노드가 하나인 경우
            if (cur.left != null) { //좌측에 자식노드가 있는 경우
                child = cur.left;
            } else {
                child = cur.right; //우측에 자식 노드가 있는 경우
            }
            if (parent == null) { //루트노드이며 자식이 하나만 있는 경우
                this.head = child;
            } else {
                if (parent.left == cur) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        } else { //자식 노드가 둘인 경우
            predecessor = cur; //왼쪽에서 가장 큰거 찾을거임
            successor = cur.left;

            while (successor.right != null){
                predecessor = successor;
                successor = successor.right;
            }

            predecessor.right = successor.left; //successor은 올라갈 예정
            successor.left = cur.right;
            successor.right = cur.right;

            if(parent == null){
                this.head = successor;
            }else{
                if(parent.left == null){
                    parent.left = successor;
                }else{
                    parent.right = successor;
                }
            }
        }
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        //TestCode
        //노드 삽입
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

        //노드 삭제
        bst.removeNode(40);
        bst.levelOrder(bst.head);

        bst.removeNode(25);
        bst.levelOrder(bst.head);

        bst.removeNode(20);
        bst.levelOrder(bst.head);

    }
}
