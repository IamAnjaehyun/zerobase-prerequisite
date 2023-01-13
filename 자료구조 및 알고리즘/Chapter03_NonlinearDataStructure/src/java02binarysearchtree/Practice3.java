package java02binarysearchtree;
//Practice3
//비선형 자료구조 - 이진 탐색 트리 _ 2
// AVL 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node3 {
    int key;
    int height; //현재 노드가 트리에서 어떤 높이인지
    Node3 left;
    Node3 right;

    public Node3(int key, Node3 left, Node3 right) {
        this.key = key;
        this.height = 0; //시작할때 높이는 항상 0
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    Node3 head;

    public int height(Node3 node3) {
        if (node3 == null) {
            return -1;
        }
        return node3.height;
    }

    public Node3 rightRotate(Node3 node3) { //ll case -> rightRotate
        Node3 lNode = node3.left; //왼쪽노드

        node3.left = lNode.right;
        lNode.right = node3;

        node3.height = Math.max(height(node3.left), height(node3.right)) + 1;
        lNode.height = Math.max(height(lNode.left), height(lNode.right)) + 1;

        return lNode;
    }

    public Node3 leftRotate(Node3 node3) { //rr case -> leftRotate
        Node3 rNode = node3.right; //왼쪽노드

        node3.right = rNode.left;
        rNode.left = node3;

        node3.height = Math.max(height(node3.left), height(node3.right)) + 1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }

    public Node3 lrRotate(Node3 node3) { //lr case (< / ㅅ)
        node3.left = leftRotate(node3.left);
        return rightRotate(node3);
    }

    public Node3 rlRotate(Node3 node3) { //rl case (> \ ㅅ)
        node3.right = rightRotate(node3.right);
        return leftRotate(node3);
    }

    public int getBalance(Node3 node3) { //균형정보 계산 -1,0,1이면 정상 , 높이차 계산해서 리턴
        if (node3 == null) {
            return 0;
        }
        return height(node3.left) - height(node3.right);
    }

    public void insert(int key) { //노드 삽입 ( 재귀형태 ) + balance 계산
        this.head = insert(this.head, key);
    }

    public Node3 insert(Node3 node3, int key) {
        if (node3 == null) {
            return new Node3(key, null, null);
        }
        //기본적인 삽입
        if (key < node3.key) { //데이터가 있다면
            node3.left = insert(node3.left, key);
        } else {
            node3.right = insert(node3.right, key);
        }

        //높이 갱신
        node3.height = Math.max(height(node3.left), height(node3.right)) + 1;
        //밸런스 체크
        int balance = getBalance(node3); //삽입한 노드의 높이차이를 계산하고 나서 이상이 없으면 넘어가고 있으면 회전연산 진행

        //LL
        if (balance > 1 && key < node3.left.key) {
            return rightRotate(node3);
        }

        //RR
        if(balance < -1 && key > node3.right.key){
            return leftRotate(node3);
        }

        //LR
        if(balance > 1 && key > node3.left.key){
            return lrRotate(node3);
        }

        //RL
        if(balance < -1 && key < node3.right.key){
            return rlRotate(node3);
        }

        return node3;
    }

    public void levelOrder(Node3 node) {
        Queue<Node3> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node3 cur = queue.poll();

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

public class Practice3 {
    public static void main(String[] args) {
        //TestCode
        AVLTree avl = new AVLTree();

        //Insert
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);     //LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.insert(50);     //RR
        avl.levelOrder(avl.head);

        avl.insert(5);
        avl.insert(7);      //LR
        avl.levelOrder(avl.head);

        avl.insert(60);
        avl.insert(55);     //RL
        avl.levelOrder(avl.head);
    }
}
