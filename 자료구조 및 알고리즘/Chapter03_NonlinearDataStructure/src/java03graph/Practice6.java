package java03graph;
//Practice6
//주어진 그래프를 두 개의 그래프로 분리할 수 있는지 확인 하는 프로그램을 작성하세요.
//분리 조건 : 인접하지 않은 노드끼리 분리

//모든 노드는 연결되어 있다.
//분리 가능하면 true, 불가능하면 false 출력

//예시 입력 )
//그래프 :{{1, 3}, {0, 2}, {1, 3}, {0, 2}} > 0번노드가 1,3 에 연결 / 1번노드가 0,2에 연결 / 2번노드가 1,3에 연결 / 3번노드가 0,2에 연결
//출력 : true

//그래프 : {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}
//출력 false
public class Practice6 {
    public static void solution(int[][] graph) {
        int[] flags = new int[graph.length]; //간선 정보가 아니라 그대로 길이 잡으면 됨

        if (checkSplit(graph, flags, 1, 0) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean checkSplit(int[][] graph, int[] flags, int flag, int node) {
        if(flags[node] != 0){ //이미 방문했었다는 뜻 , setting 해야하는 flag 값이랑 다른 값이 세팅이 되어있으면 인접한거로 인해 케이스가 어긋난것
            return flags[node] == flag; //같으면 true, 다르면 false
        }

        flags[node] = flag; //호출시에 노드 해당 위치 플래그를 설정하라는 flag값으로 설정
        for (int adjacentNode : graph[node]) { //노드와 연결되어 있는 노드들 하나씩 checkSplit 호출
            if (!checkSplit(graph, flags, -flag, adjacentNode)) { //인접한 애들 -flag로 반전 시켜줌
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //TestCode
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        solution(graph);

        graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        solution(graph);

    }
}
