package java10shortestpath;

public class FloydWarshall {

    static int[][] dist;
    static final int INF = 10000000;

    public static void floydWarshall(int v, int e, int[][] data, int start) {
        dist = new int[v + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < v + 1; j++) {
                if (i != j) { //대각선이 아닐땐 INF 대각선은 0
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < e; i++) {//그래프 구성
            dist[data[i][0]][data[i][1]] = data[i][2]; //dist[출발지][도착지] = weight값 > 인접한 노드로의 값이 업데이트 됨
        }

        for (int k = 1; k < v + 1; k++) {// 1부터 정점 수 만큼\
            //i -> j (k를 거쳐서 가는 경우가 짧을 때 업데이트)
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) { //거쳐가는 경우 무한이면 안됨, k부터 도착지 무한이면 안됨
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        //출력
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (dist[i][j] >= INF) {
                    System.out.printf("%5s ", "INF");
                } else {
                    System.out.printf("%5s ", dist[i][j]);
                }
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        //TestCode
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
        System.out.println();

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
    }
}
