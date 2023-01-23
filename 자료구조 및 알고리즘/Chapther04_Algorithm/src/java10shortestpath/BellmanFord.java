package java10shortestpath;

public class BellmanFord {

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

    public static void bellmanFord(int v, int e, int[][] data, int start) {
        Edge[] edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }

        int[] dist = new int[v + 1]; //1번노드부터 시작하기 때문
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0; //출발지 0

        boolean isMinusCycle = false;
        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edge[j]; //엣지가 어떤순서냐에 따라 기존 출발지에 무한대가 되어있으면 업데이트가 의미가 없음

                if (dist[cur.from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dist[cur.to] > dist[cur.from] + cur.weight) {   //기존의 값 보다 경유해서 가는 경로의 길이가 더 짧으면
                    dist[cur.to] = dist[cur.from] + cur.weight;     //더 짧은 경로로 업데이트

                    if (i == v) { //업데이트가 일어난 경우(음수사이클이 있던 경우)
                        isMinusCycle = true;
                    }
                }
            }
        }
        System.out.println("음수 사이클 발생 : " + isMinusCycle);
        for (int i = 1; i < v+1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.print(dist[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        //TestCode
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);
        System.out.println();

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);
    }
}
