package java07practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice7 {

    public static int[] solution(int[][] intervals, int[] queries) {
        if (intervals == null || queries == null) {
            return null;
        }

        if (intervals.length == 0 || intervals[0].length == 0 || queries.length == 0) {
            return null;
        }

        int[][] queriesBackup = new int[queries.length][2];
        for (int i = 0; i < queriesBackup.length; i++) {
            queriesBackup[i] = new int[]{queries[i], i};
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> (x[1] - x[0]) - (y[1] - y[0])); //간격값 기준 minHeap
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0])); //시작구간 기준 오름차순
        Arrays.sort(queriesBackup, (x, y) -> (x[0] - y[0])); //좌측값 기준 오름차순

        int[] result = new int[queries.length];

        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            int queryVal = queriesBackup[i][0];
            int queryIndex = queriesBackup[i][1];

            while (j < intervals.length && intervals[j][0] <= queryVal) { //정렬 된 상태에서 구간에 있는 애들만 갖고 heap 구현
                minHeap.add(intervals[j]);
                j++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryVal) { //구간안에 포함 X 그러므로 삭제
                minHeap.remove();
            }

            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1);
        }


        return result;
    }

    public static void main(String[] args) {
        //TestCode
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(intervals, queries)));

        intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        queries = new int[]{2, 19, 5, 22};
        System.out.println(Arrays.toString(solution(intervals, queries)));

    }
}
