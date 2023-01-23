package java10shortestpath;

import java.util.ArrayList;

public class Dijkstra {
    static class Noded {
        int to;
        int weight;

        public Noded(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {
        ArrayList<ArrayList<Noded>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) { //노드번호가 1부터 시작을 해서 편의를 위해
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Noded(data[i][1], data[i][2]));
        }

        int[] dist = new int[v + 1]; //최단거리 경로 기록할 dp용 메모리
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        boolean[] visited = new boolean[v + 1];

        for (int i = 0; i < v; i++) {
            int minDist = Integer.MAX_VALUE;
            int curIdx = 0;
            for (int j = 1; j < v + 1; j++) {
                if (!visited[j] && dist[j] < minDist) { //방문한적 없고 min 보다 작아서 최소
                    minDist = dist[j];
                    curIdx = j;
                }
            }

            visited[curIdx] = true;

            for (int j = 0; j < graph.get(curIdx).size(); j++) { //인접노드 사이즈
                Noded adjNode = graph.get(curIdx).get(j);
                if (dist[adjNode.to] > dist[curIdx] + adjNode.weight) { //원래 거리정보 배열에 있던 값 보다 현재 거리랑 + 거쳐서가는 해당 비용이 작으면 업데이트
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight;
                }
            }
        }
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE){
                System.out.println("INF ");
            }else{
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //TestCode
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }
}
