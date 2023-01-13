package java02binarysearchtree;
//비선형 자료구조 - 이진 탐색 트리_3
//Red-Black 트리 - 삽입 ( 코테에 나오진 않음 )

import com.sun.corba.se.pept.encoding.InputObject;
import com.sun.glass.events.mac.NpapiEvent;
import sun.awt.geom.AreaOp;

import java.util.LinkedList;
import java.util.Queue;

class Node5 {
    int key;
    int color;
    Node5 left;
    Node5 right;
    Node5 parent;

    public Node5(int key, int color, Node5 left, Node5 right, Node5 parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class RedBlackTree {
    static final int BLACK = 0;
    static final int RED = 1;

    Node5 head;

    public void insert(int key) {
        Node5 checkNode = null; //새로운 데이터 추가로 인해 그 부분을 기점으로 리밸런싱이 필요할 때 그 부분을 찝어놓은 변수
        if (this.head == null) {
            this.head = new Node5(key, BLACK, null, null, null);
        } else { //head 가 있는 상황
            Node5 cur = this.head;

            while (true) { //데이터 추가할 위치 찾음
                Node5 pre = cur;

                if (key < cur.key) { //왼쪽으로 들어가는 경우
                    cur = cur.left;
                    if (cur == null) {
                        pre.left = new Node5(key, RED, null, null, pre); //프리에 왼쪽에 추가
                        checkNode = pre.left;
                        break;
                    }
                } else { //오른쪽으로 들어가는 경우
                    cur = cur.right;

                    if (cur == null) { //우측으로 데이터 추가
                        pre.right = new Node5(key, RED, null, null, pre);
                        checkNode = pre.right;
                        break;
                    }
                }
            }
            reBalance(checkNode);
        }
    }

    public void reBalance(Node5 node5) {
        while (node5.parent != null && node5.parent.color == RED) { //double red 상황
            Node5 sibling = null; //형제노드

            if (node5.parent == node5.parent.parent.left) {
                sibling = node5.parent.parent.right; //부모의 형제
            } else {
                sibling = node5.parent.parent.left;
            }

            if (sibling != null && sibling.color == RED) { //형제노드 빨간색
                node5.parent.color = BLACK; //부모 검정색
                sibling.color = BLACK; //부모의 형제도 검정
                node5.parent.parent.color = RED; //부모의 부모는 빨간색

                //부모가 루트면 끝 아니면 다시 반복
                if (node5.parent.parent == this.head) {
                    node5.parent.parent.color = BLACK;
                    break;
                } else { //루트가 아님
                    node5 = node5.parent.parent;
                    continue; //node5를 다시 리밸런싱
                }
            } else { //reStructure
                if (node5.parent == node5.parent.parent.left) { // 부모노드의 형제가 없거나 black 일 때
                    if (node5 == node5.parent.right) { //lr 일 때 ll되도록
                        node5 = node5.parent;
                        //회전
                        leftRotate(node5);
                    }
                    node5.parent.color = BLACK;
                    node5.parent.parent.color = RED;
                    rightRotate(node5.parent.parent);
                } else if (node5.parent == node5.parent.parent.right) {
                    if (node5 == node5.parent.left) {
                        node5 = node5.parent;
                        rightRotate(node5);
                    }
                    node5.parent.color = BLACK;
                    node5.parent.parent.color = RED;
                    leftRotate(node5.parent.parent);
                }
                break;
            }

        }
    }

    //LeftRotate
    public void leftRotate(Node5 node5) {
        if (node5.parent == null) {
            Node5 rNode = this.head.right;
            this.head.right = rNode.left;
            rNode.left.parent = this.head;
            this.head.parent = rNode;
            rNode.left = this.head;
            this.head = rNode;
        } else {
            if (node5 == node5.parent.left) {
                node5.parent.left = node5.right;
            } else {
                node5.parent.right = node5.right;
            }
            node5.right.parent = node5.parent;
            node5.parent = node5.right;

            if (node5.right.left != null) {
                node5.right.left.parent = node5;
            }
            node5.right = node5.right.left;
            node5.parent.left = node5;
        }
    }

    //RightRotate
    public void rightRotate(Node5 node5) {
        if (node5.parent == null) {
            Node5 lNode = this.head.left;
            this.head.left = lNode.right;
            lNode.right.parent = this.head;
            this.head.parent = lNode;
            lNode.right = this.head;
            lNode.parent = null;
            this.head = lNode;
        } else {
            if (node5 == node5.parent.left) {
                node5.parent.left = node5.left;
            } else {
                node5.parent.right = node5.right;
            }

            node5.left.parent = node5.parent;
            node5.parent = node5.left;

            if (node5.left.right != null) {
                node5.left.right.parent = node5;
            }

            node5.left = node5.left.right;
            node5.parent.right = node5;
        }
    }

    public void levelOrder(Node5 node5) {
        char[] color = {'B', 'R'};

        Queue<Node5> queue = new LinkedList<>();
        queue.add(node5);
        while (!queue.isEmpty()) {
            Node5 cur = queue.poll();

            System.out.print("[" + color[cur.color] + "]" + cur.key + " ");
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


public class Practice5 {
    public static void main(String[] args) {
        //TestCode

        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(20);
        rbTree.insert(10);
        rbTree.insert(30);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(25);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(20);
        rbTree.levelOrder(rbTree.head);

    }
}
