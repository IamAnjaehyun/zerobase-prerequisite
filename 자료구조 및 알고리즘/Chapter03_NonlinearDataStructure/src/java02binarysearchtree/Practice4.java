package java02binarysearchtree;
//AVL 트리 - 삭제

import java.util.Map;

class AVLTree2 extends AVLTree {
    public void delete(int key) {
        this.head = delete(this.head, key);
    }

    public Node3 delete(Node3 node3, int key) {
        if (node3 == null) {
            return null;
        }
        if (key < node3.key) {
            node3.left = delete(node3.left, key);
        } else if (key > node3.key) {
            node3.right = delete(node3.right, key);
        } else { //삭제
            if (node3.left == null) { //자식이 하나이거나 없거나
                return node3.right;
            } else if (node3.right == null) { //자식이 하나이거나 없거나
                return node3.left;
            } else { //자식 노드가 둘인 경우 (좌측서브트리에서 가장 큰거 찾을거임)
                Node3 predecessor = node3;
                Node3 successor = node3.left;

                while (successor.right != null) { //좌측서브트리에서 가장 큰거 찾을거임
                    predecessor = successor;
                    successor = successor.right;
                }

                predecessor.right = successor.left;
                node3.key = successor.key;
            }
        }

        node3.height = Math.max(height(node3.left), height(node3.right)) + 1;

        int balance = getBalance(node3);

        //LL
        if (balance > 1 && getBalance(node3.left) > 0) {
            return rightRotate(node3);
        }

        //RR
        if (balance < -1 && getBalance(node3.right) < 0) {    // '/' 형태
            return leftRotate(node3);
        }

        //LR
        if (balance > 1 && getBalance(node3.left) < 0) {          // '\' 형태
            return lrRotate(node3);
        }

        //RL
        if (balance < -1 && getBalance(node3.right) > 0) {
            return rlRotate(node3);
        }

        return node3;
    }
}


public class Practice4 {
    public static void main(String[] args) {
        //TestCode
        AVLTree2 avl = new AVLTree2();

        avl.insert(30);
        avl.insert(20);
        avl.insert(10);
        avl.insert(40);
        avl.levelOrder(avl.head);
        avl.delete(40);         //LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.delete(10);         //RR
        avl.levelOrder(avl.head);

        avl.insert(25);
        avl.delete(40);         //LR
        avl.levelOrder(avl.head);

        avl.insert(27);
        avl.delete(20);         //RL
        avl.levelOrder(avl.head);
    }
}
