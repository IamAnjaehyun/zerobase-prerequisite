package java03graph;
//Practice4
//Center Node 찾기
//Undirected 그래프에서 Center Node를 출력하세요.
//Center Node는 다른 모든 노드와 연결된 노드를 의미
//간선의 개수가 가장 많은 노드 찾기

//입력 그래프 : {{1,2},{2,3},{4,2}}
//출력 : 2

//입력 그래프 : {{1,2},{5,1},{1,3},{1,4}}
//출력 : 1

class MyGraphMatrix4 {
    char vertices[];
    int[][] adjMat;
    int elemCnt;

    public MyGraphMatrix4() {
    }

    public MyGraphMatrix4(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is Full!");
            return;
        }
        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;

    }
}


public class Practice4 {
    public static int solution(int[][] e) {
        MyGraphMatrix4 graph = new MyGraphMatrix4(e.length + 1); //edge가 노드간 연결된 간선 정보이기 때문

        for (int i = 0; i < e.length; i++) { //간선 정보 추가
            graph.addEdge(e[i][0] - 1, e[i][1] - 1); //0베이스로 들어갈 수 있게
        }
        int[] edgeCnt = new int[e.length + 1];
        for (int i = 0; i < graph.adjMat.length; i++) { //인접 행렬 안에 노드가 1이 된 부분 체크해서 카운팅
            for (int j = 0; j < graph.adjMat[i].length; j++) {
                if (graph.adjMat[i][j] == 1) {
                    edgeCnt[i] += 1;
                }
            }
        }
        int maxCnt = -1;
        int maxIdx = -1;
        for (int i = 0; i < edgeCnt.length; i++) {
            if (maxCnt < edgeCnt[i]) {
                maxCnt = edgeCnt[i];
                maxIdx = i;
            }
        }
        return maxIdx + 1; //위에서 1씩 뺐었으니까
    }

    //간선의 총 개수는 노드의 개수 -1
    //모든 노드는 연결되어 있다. 라는 조건 하에
    //유레카..!!
    public static int solution2(int[][] e) {
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }

    public static void main(String[] args) {
        //TestCode
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();

        edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
    }
}
