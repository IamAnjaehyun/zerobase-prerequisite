package java08practice;

import java.util.LinkedList;
import java.util.Queue;

class Doc{
    int no;
    int priority;

    public Doc(int no, int priority) {
        this.no = no;
        this.priority = priority;
    }
}

public class Practice6 {
    public static void solution(int docs, int target, int[] priority) {
        Queue<Doc> queue = new LinkedList<>();

        for (int i = 0; i < docs; i++) {
            queue.add(new Doc(i,priority[i]));
        }

        int cnt = 1;
        while (true){
            Doc cur = queue.poll();
            //Queue를 스트링으로 쓰면서 우선순위가 높은거 거름
            Doc[] highP = queue.stream().filter(x -> x.priority > cur.priority).toArray(Doc[]::new);

            if(highP.length>0){ //우선순위 높은게 있다는 뜻
                queue.add(cur);
            }else{ //우선순위 높은거 없으면 현재 문서 출력
                if(cur.no == target){
                    System.out.println(cnt);
                    break;
                }
                cnt++; //출력횟수
            }
        }
    }

    public static void main(String[] args) {
        //TestCode
        int docs = 1;
        int target = 0;
        int[] priority = {5};
        solution(docs, target, priority);

        docs = 4;
        target = 2;
        priority = new int[]{1, 2, 3, 4};
        solution(docs, target, priority);

        docs = 6;
        target = 0;
        priority = new int[]{1, 1, 9, 1, 1, 1};
        solution(docs, target, priority);

    }
}
