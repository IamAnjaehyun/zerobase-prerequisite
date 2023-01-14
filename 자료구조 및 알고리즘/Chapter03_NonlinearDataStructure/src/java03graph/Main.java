package java03graph;
//비선형 자료구조 - 그래프
//인접 행렬을 이용한 그래프 구현

class MyGraphMatrix {
    char[] vertices; //알파벳 담을 데이터 변수
    int[][] adjMat; //이차원 인접 행렬
    int elemCnt; //그래프에 정점의 개수가 몇개 들어왔는지 셀 변수

    public MyGraphMatrix() {
    }

    public MyGraphMatrix(int size) {
        vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) { //새로운 알파벳 정점 추가
        if (isFull()) {
            System.out.println("Graph is Full!");
            return;
        }

        this.vertices[this.elemCnt++] = data; //꽉차있지 않으면 해당 위치에 데이터 넣음
    }

    public void addEdge(int x, int y) { //무방향 그래프 일 때
        this.adjMat[x][y] = 1; //0행1열 1
        this.adjMat[y][x] = 1; //무방향이라 하나 더
    }

    public void addDirectedEdge(int x, int y) { //방향그래프 일 때
        this.adjMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {//무방향 그래프 일 때
        this.adjMat[x][y] = 0; //0행1열 0
        this.adjMat[y][x] = 0; //무방향이라 하나 더
    }

    public void deleteDirectedEdge(int x, int y) {//방향그래프 일 때
        this.adjMat[x][y] = 0;
    }

    public void printAdjacentMatrix(){ //인접행렬 출력
        System.out.print("  ");
        for(char item : this.vertices){
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elemCnt; i++) { //정점 개수만큼 출력
            System.out.print(this.vertices[i] + " ");
            for (int j = 0; j < this.elemCnt; j++) {
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //TestCode
        MyGraphMatrix graph = new MyGraphMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printAdjacentMatrix();
    }
}
