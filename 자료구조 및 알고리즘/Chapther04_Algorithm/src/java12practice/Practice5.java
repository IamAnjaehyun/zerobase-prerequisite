package java12practice;

import java11mst.Practice1;

import java.util.ArrayList;
import java.util.Collections;

//MST - kruskal
public class Practice5 {

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int[] parents;
    static ArrayList<Edge> edgeList;

    public static int solution(int n, int m, int data[][]) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return -1;
        }

        edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edgeList.add(new Edge(data[i][0], data[i][1], data[i][2]));
        }

        //최악 경로
        Collections.sort(edgeList, (x, y) -> x.weight - y.weight); //오름차순 0인애들부터 선택되서 mst 구성
        //kruskal
        int weightSum1 = kruskal(n, edgeList);

        //최적 경로
        Collections.sort(edgeList, (x, y) -> y.weight - x.weight); //내림차순 1인애들부터 선택되서 mst 구성
        //kruskal
        int weightSum2 = kruskal(n, edgeList);


        return weightSum1 * weightSum1 - weightSum2 * weightSum2;

    }

    public static int kruskal(int n, ArrayList<Edge> edges) {
        parents = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int weightSum = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);

                if (edge.weight == 0) {
                    weightSum++; //오르막길 몇번인지 리턴
                }
            }

        }
        return weightSum;
    }

    public static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[aP] = bP;
        }
    }

    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }


    public static void main(String[] args) {
        //TestCode
        int n = 4;
        int m = 5;
        int[][] data = {{1, 2, 0}, {1, 4, 0}, {2, 3, 0}, {3, 4, 1}, {4, 2, 1}};

        System.out.println(solution(n, m, data));
    }
}
