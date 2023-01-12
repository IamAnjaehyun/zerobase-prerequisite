package java01tree;
// Practice1
// 배열을 이용한 이진 트리 구성, 순회
// 들어온 데이터를 순서대로 배열에 넣은 상태

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone();
    }


    //현재 > 왼쪽 > 오른쪽
    //          A
    //      B       C
    //    D   E   F   G
    //   H I J
    public void preOrder(int idx) {
        System.out.print(this.arr[idx] + " ");
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if (left < this.arr.length) {
            this.preOrder(left);
        }

        if (right < this.arr.length) {
            this.preOrder(right);
        }
    }

    //왼쪽 현재 오른쪽
    public void inOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < this.arr.length) {
            this.inOrder(left);
        }

        System.out.print(this.arr[idx] + " ");

        if (right < this.arr.length) {
            this.inOrder(right);
        }
    }

    //왼쪽 오른쪽 현재
    public void postOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < this.arr.length) {
            this.postOrder(left);
        }

        if (right < this.arr.length) {
            this.postOrder(right);
        }

        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(int idx){
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        //TestCode
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("==PreOrder==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("==InOrder==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("==PostOrder==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("==PostOrder==");
        bt.levelOrder(0);
        System.out.println();
    }
}