package java04heap;

//Practice4
//정수들을 힙 자료구조에 추가하고 n번 삭제 후 절대값이 큰 값부터 출력하세요. (큰값 자료구조 -> MaxHeap 사용)

import java.util.ArrayList;
import java.util.stream.IntStream;

//입력 : 3, 0, -2, -5, 9, 6, -11, 20, -30
//삭제 횟수 : 1
//출력  : 20, -11, 9, 6 ,-5, 3, -2, 0
class Num {
    int val;
    boolean isMinus;

    public Num(int val) {
        this.isMinus = val < 0 ? true : false;
        this.val = Math.abs(val);
    }
}

class MaxHeap4 {
    ArrayList<Num> heap;

    public MaxHeap4() {
        this.heap = new ArrayList<>();
        this.heap.add(new Num(0)); //인덱스 기준 1번부터 시작 할 수 있도록 더미 데이터 넣음
    }

    //max힙은 부모쪽으로 데이터 큰 값이 올라가야 함
    public void insert(int data) {
        heap.add(new Num(data)); //가장 끝쪽에 데이터 들어감

        int cur = heap.size() - 1; //마지막위치의 -1
        while (cur > 1 && heap.get(cur / 2).val < heap.get(cur).val) { // cur/2 = 부모의 인덱스
            Num parentVal = heap.get(cur / 2);
            heap.set(cur / 2, heap.get(cur)); //부모쪽에는 방금 들어온 데이터
            heap.set(cur, parentVal);//cur 에는 부모의 데이터 넣어줌

            cur /= 2; //위로 올라가서 체크 반복반복
        }
    }

    public Num delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is Empty");
            return null;
        }

        Num target = heap.get(1); //heap 기준 가장 상위 데이터
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        //가장 위 데이터가 루트자리에 부합하는지
        int cur = 1; //인덱스
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) { //자식노드 둘다있는 케이스
                targetIdx = heap.get(leftIdx).val > heap.get(rightIdx).val ? leftIdx : rightIdx; //두 자식 중 더 큰값 고를 수 있게 바꿔줌
            } else if (leftIdx < heap.size()) { //자식 하나인 경우
                targetIdx = leftIdx; //(cur * 2)
            } else { //자식노드가 없음 부모노드밖에 없거나 리프노드
                break;
            }
            if (heap.get(cur).val > heap.get(targetIdx).val) {
                break;
            } else {
                Num parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target; //target = heap.get(1);
    }
}

public class Practice4 {
    public static void solution(int[] nums, int deleteCnt) {
        MaxHeap4 maxHeap = new MaxHeap4();
        IntStream.of(nums).forEach(x->maxHeap.insert(x));

        int cnt = 0;
        while (maxHeap.heap.size() != 1){
            Num cur = maxHeap.delete();

            if(cnt++ < deleteCnt){
                continue;
            }

            int oriVal = cur.isMinus ? cur.val * -1 : cur.val;
            System.out.print(oriVal + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //TestCode
        int nums[] = {3, 0, -2, -5, 9, 6, -11, 20, -30};
        int deleteCnt = 1;
        System.out.println("제일 큰거 하나 지운 후 절대값이 큰 값 부터 출력");
        solution(nums, deleteCnt);
    }
}
