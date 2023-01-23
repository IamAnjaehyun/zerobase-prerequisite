package java11mst;

import java.util.Arrays;

//알고리즘 - 최소 신장 트리
//크루스칼 알고리즘
public class Kruskal {
    static int parents[]; //사이클 판단을 위해


    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;

        Arrays.sort(data, (x, y) -> x[2] - y[2]); //간선 기준으로 오름차순이 되도록 정렬

        parents = new int[v + 1]; //1번부터

        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) { //작은순서대로 연결
            if(find(data[i][0]) != find(data[i][1])){
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }


        return weightSum;
    }

    public static void union(int a, int b) { //연결이 되었을 때 두개의 노드를 같은 집합으로 묶어줌
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[aP] = bP; //같은 부모가 되도록
        }
    }

    public static int find(int a) { //a노드가 최종적으로 어디에 연결되었는지
        if (a == parents[a]) {

            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) {
        //TestCode
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};

        System.out.println(kruskal(graph, v, e));
    }


}
