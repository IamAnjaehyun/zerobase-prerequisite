package java02binarysearchtree;
//Practice6
//주어진 이진 탐색 트리에서 N번째로 작은 수 구하기 > 오름차순으로 나열만 시키면 됨(inOrder)

//입력 트리 : 3, 1, 4, null, 2
//N : 1
//결과 : 1

//입력 트리 : 5, 3, 6, 2, 4, null, null, 1
//N : 3
//결과 : 3

import java.util.ArrayList;

class Node6 {
    int key;
    Node6 left;
    Node6 right;

    public Node6(int key, Node6 left, Node6 right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree6 {
    Node6 head;

    BinarySearchTree6() {
    }

    BinarySearchTree6(int key) {
        this.head = new Node6(key, null, null);
    }

    public void addNode(int key) {
        this.head = this.addNode(this.head, key);
    }

    public Node6 addNode(Node6 cur, int key) {
        if (cur == null) {
            return new Node6(key, null, null);
        }

        if (key < cur.key) {
            cur.left = addNode(cur.left, key);
        }else{
            cur.right = addNode(cur.right, key);
        }
        return cur;
    }
}

public class Practice6 {
    public static void solution(Integer[] data, int n) {
        BinarySearchTree6 bst = new BinarySearchTree6(data[0]); //루트에 데이터가 잡힐 수 있도록
        for (int i = 1; i < data.length; i++) {
            if(data[i] ==null){
                continue;
            }
            bst.addNode(data[i]);
        }
        ArrayList<Integer> list = new ArrayList();
        inOrder(bst.head,list); //호출 끝나면 데이터가 오름차순으로 들어가있음
        System.out.println(list.get(n-1)); //0부터 시작이라 1빼줌
    }

    public static void inOrder(Node6 node6, ArrayList list){
        if(node6==null){
            return;
        }
        inOrder(node6.left, list); //좌측먼저
        list.add(node6.key); //오름차순으로 들어감
        inOrder(node6.right, list);

    }

    public static void main(String[] args) {
        //TestCode
        Integer[] data = {3, 1, 4, null, 2};
        int n = 1;
        solution(data, n);

        data = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        n = 3;
        solution(data, n);
    }
}
