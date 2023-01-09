package java06deque;
//Practice5
//데크 변형

//기본 데크 구조에서 중간에 데이터를 추가하는 기능을 구현하세요 ( 원래는 양쪽 끝에서만 가능 )
//단, 추가적인 자료구조 생성하지 말고 구현

//입력 예시)
//초기 데크 상태 (size : 5)
// ->1,2,3,4
//중간 입력 : 10
//결과 데크
// ->1,2,10,3,4

class MyDeque {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque(int size) {
        this.arr = new int[size + 1]; //원형이라 front가 가리키는게 하나 없어서 +1
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void addFirst(int data) {
        if (this.isFull()) {
            System.out.println("Deque is Full");
            return;
        }
        this.arr[this.front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length; //원형이라서
    }

    public void addLast(int data) {
        if (this.isFull()) {
            System.out.println("Deque is Full");
            return;
        }
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public void addMiddle(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full");
            return;
        }

        int elements = this.rear - this.front;
        if (elements < 0) {
            elements = this.arr.length + elements; //원형이라 rear - front 하면 음수가 나올 수 있으니 이렇게 사용
        }

        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;

        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;
        for (int i = start; i != end; i = (i - 1 + this.arr.length) % this.arr.length) { //mid 지점 이후에 있는 데이터들 >> 방향으로 데이터 밀어서 mid지점에 있던 데이터 옆으로 복사
            this.arr[i] = this.arr[(i-1 + this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data; //mid에 데이터 갱신
        this.rear = (this.rear + 1) % this.arr.length;
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }
        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}

public class Practice5 {
    public static void main(String[] args) {
        //TestCode
        MyDeque myDeque1 = new MyDeque(5);
        myDeque1.addLast(1);
        myDeque1.addLast(2);
        myDeque1.addLast(3);
        myDeque1.addLast(4);
        myDeque1.printDeque();

        myDeque1.addMiddle(10);
        myDeque1.printDeque();

        MyDeque myDeque2 = new MyDeque(5);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.addLast(11);
        myDeque2.addLast(12);
        myDeque2.addLast(13);
        myDeque2.printDeque();

        myDeque2.addMiddle(100);
        myDeque2.printDeque();

    }
}
