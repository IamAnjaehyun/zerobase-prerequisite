package java04heap;
//비선형 자료구조 - 힙
//ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); //인덱스 기준 1번부터 시작 할 수 있도록 더미 데이터 넣음
    }

    public void insert(int data) {
        heap.add(data); //가장 끝쪽에 데이터 들어감

        //키값 비교 후 부모의 키 값이 더 크면 자기 자신을 위로 올리면 됨
        int cur = heap.size() - 1; //마지막위치의 -1
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) { // cur/2 = 부모의 인덱스
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data); //부모쪽에는 방금 들어온 데이터
            heap.set(cur, parentVal);//cur 에는 부모의 데이터 넣어줌

            cur /= 2; //위로 올라가서 체크 반복반복
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is Empty");
            return null;
        }

        int target = heap.get(1); //heap 기준 가장 상위 데이터
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        //가장 위 데이터가 루트자리에 부합하는지
        int cur = 1; //인덱스
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) { //자식노드 둘다있는 케이스
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx; //해당하는 자식의 idx 반환
            } else if (leftIdx < heap.size()) { //자식 하나인 경우
                targetIdx = leftIdx; //(cur * 2)
            }else { //자식노드가 없음 부모노드밖에 없거나 리프노드
                break;
            }
            if(heap.get(cur) < heap.get(targetIdx)){
                break;
            }else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target; //target = heap.get(1);
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        //TestCode
        MinHeap minHeap = new MinHeap();
        System.out.println("==데이터 삽입==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.printTree();
        minHeap.insert(10);
        minHeap.printTree();

        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();

        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println("==데이터 삭제==");
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
    }
}
