package java03graph;
//Practice5
//주어진 그래프에서 시작 노드에서 끝 노드로 가는 길이 있는지 확인하는 프로그램을 작성하세요.
//path 가 존재하면 ture 없으면 false 출력

import java.util.ArrayList;
import java.util.Stack;

//입력 예시)
//노드 개수 = 3
//간선 정보 = {{0,1},{1,2},{2,0}}
//출발 노드 = 0
//종착 노드 = 2
//출력 : true
class Node5{
    int id;
    Node5 next;

    public Node5(int id, Node5 next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList5{
    int[] vertices;
    Node5[] adjList;
    int elemCnt;

    public MyGraphList5(){}
    public MyGraphList5(int size){
        this.vertices = new int[size];
        this.adjList = new Node5[size];
        this.elemCnt = 0;
    }

    public boolean isFull(){return this.elemCnt == this.vertices.length;}

    public void addVertex(int data){
        if(isFull()){
            System.out.println("Graph is Full!");
            return;
        }
        this.vertices[elemCnt++] = data;
    }
    public void addEdge(int x, int y){
        this.adjList[x] = new Node5(y,this.adjList[x]);
        this.adjList[y] = new Node5(x,this.adjList[y]);
    }
}


public class Practice5 {
    public static void solution(int n, int[][] edges, int source, int dest){
        MyGraphList5 graph = new MyGraphList5(n);

        for (int i = 0; i < n; i++) {
            graph.addVertex(i);
        }

        for (int i = 0; i < edges.length; i++) { //간선정보
            graph.addEdge(edges[i][0], edges[i][1]);
        }
        //dfs 로 돌면서 방문했던 애들 기록
        ArrayList<Integer> visitedItem = new ArrayList<>();
        dfs(graph,0,visitedItem);

        if(visitedItem.contains(source) && visitedItem.contains(dest)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public static void dfs(MyGraphList5 graph, int id, ArrayList<Integer> visitedItem){
        boolean[] visited = new boolean[graph.vertices.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()){
            int curId = stack.pop();

            visitedItem.add(curId);

            Node5 cur = graph.adjList[curId];
            while (cur != null){
                if(visited[cur.id] == false){ //방문했던 애들 visitedItem에 다 넣음
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        //TestCode
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0;
        int dest = 2;
        solution(n,edges,source,dest);

        n=6;
        edges = new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
        source = 0;
        dest = 5;
        solution(n,edges,source,dest);

    }
}
