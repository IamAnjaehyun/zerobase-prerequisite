package java04heap;
//Practice2
//최소 힙에서 특정 값을 변경하는 코드를 작성하세요.
//특정 값이 여러개라면 모두 바꿔주세요.

import java.util.ArrayList;

class MinHeap2 {
    ArrayList<Integer> heap;

    public MinHeap2() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
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
            } else { //자식노드가 없음 부모노드밖에 없거나 리프노드
                break;
            }
            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
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

public class Practice2 {
    public static void solution(MinHeap2 minHeap, int from, int to) { // from > 변경할 값 / to > 어떤 값으로 변경될지
        for (int i = 0; i < minHeap.heap.size(); i++) {
            if (minHeap.heap.get(i) == from) {
                minHeap.heap.set(i, to); // 원하는게 있으면 i index의 값을 to의 값으로 변경

                //바꿀게 있으면 알아서 바꾸고 안바꿔도 되면 안바꿈
                moveUp(minHeap, i);
                moveDown(minHeap, i);
            }
        }
    }

    public static void moveUp(MinHeap2 minHeap, int idx) {
        int cur = idx; //현재 변경된 해당 위치에 대한 값. 이 값을 갖고 부모쪽 노드랑 값 비교 후 더 작으면 올리는 작업
        while (cur > 1 && minHeap.heap.get(cur / 2) > minHeap.heap.get(cur)) { //부모값 ,현재값 비교
            int parentVal = minHeap.heap.get(cur / 2);          //부모쪽 값을 킵해놓음
            minHeap.heap.set(cur / 2, minHeap.heap.get(cur));   //부모쪽 위치 데이터에 현재꺼 갖다두고
            minHeap.heap.set(cur, parentVal);                   //현재쪽에는 킵해뒀던 부모쪽 데이터

            cur /= 2;
        }
    }

    public static void moveDown(MinHeap2 minHeap, int idx) {
        int cur = idx;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < minHeap.heap.size()) {
                targetIdx = minHeap.heap.get(leftIdx) < minHeap.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < minHeap.heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (minHeap.heap.get(cur) < minHeap.heap.get(targetIdx)) { //현재쪽이 더 작으면 안바꿔도 됨
                break;
            }else{
                int parentVal = minHeap.heap.get(cur);
                minHeap.heap.set(cur, minHeap.heap.get(targetIdx));
                minHeap.heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
    }


    public static void main(String[] args) {
        //TestCode
        MinHeap2 minHeap = new MinHeap2();
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(20);
        minHeap.insert(30);
        System.out.println("== 데이터 변경 전 ==");
        minHeap.printTree();

        System.out.println("== 데이터 변경 후 ==");
        solution(minHeap, 30, 100);
        minHeap.printTree();

        solution(minHeap, 60, 1);
        minHeap.printTree();
    }
}
