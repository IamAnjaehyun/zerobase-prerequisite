> 그래프 (Graph)
- 정점과 간선으로 이루어진 자료 구조 (Cyclic > 이게 트리와의 차이)
  - 연결된 정점간의 관계를 표현할 수 있는 자료구조
- 그래프의 용도
  - 지하철 노선도, 통신 네트워크 ...

>그래프 구조

<img src="graphex.png" width="150" height="250" align="left" >
 
- 정점 (Vertex) : 각 노드
- 간선 (Edge) : 노드와 노드를 연결하는 선 (link, branch)
- 인접 정점 (Adjacent vertex ) : 간선 하나를 두고 바로 연결된 정점
- 정점의 차수 (Degree):
  * 무방향 그래프에서 하나의 정점에 인접한 정점의 수 
  * 무방향 그래프 모든 정점 차수의 합 = 그래프 간선 수 2배
- 진입 차수 (In-degree) : 방향 그래프에서 외부로 나가는 간선의 수
- 진출 차수 (Out-degree) : 방향 그래프에서 외부로 나가는 간선의 수
- 경로 길이 (Path length) : 경로를 구성하는데 사용된 간선이 수
- 단순 경로 (Simple path) : 경로 중에서 반복되는 정점이 없는 경우
- 사이클 (Cycle) : 단순 경로의 시작 정점과 끝 정점이 동일한 경우

> 그래프의 특징과 트리와의 차이

|    그래프    |         그래프         |                  트리                  |
|:---------:|:-------------------:|:------------------------------------:|
|    개요     | 노드와 간선으로 이루어진 자료 구조 |              그래프의 한 종류               |
|    방향성    |   방향 그래프, 무방향 그래프   |                방향 그래프                |
|    사이클    |       Cyclic        |               Acyclic                |
|    모델     |       네트워크 모델       |                계층 모델                 |
|   루트 노드   |       루트 노드 X       |                최상위 노드                |
|  부모 - 자식  |    부모 - 자식 관계 X     |              인접한 상하위 노드              |
|   간선 수    |  그래프에 따라 간선 새구 다름   |      N개의 노드로 구성된 트리의 간선 수는 N-1개      |
|    순회     |      DFS / BFS      |  Pre-, In, Post-Order / Level-order  |
|    경로     |    2개 이상의 경로 가능     |            두 노드 간의 경로는 1개            |

> 그래프의 종류
- 무방향 그래프
  - 간선에 방향이 없는 그래프 ( 양방향 이동 가능 )
  - 정점 A-B 간선의 표현 : (A,B) = (B,A)
</br></br>

- 방향 그래프
  - 간선에 방향이 있는 그래프( 해당 방향으로만 이동 가능 )
  - 정점 A -> B 간선의 표현 : <A,B> =/= <B,A> (특문 없어서 이렇게 표현 =/=)
    </br></br>

- 가중치 그래프
  - 간선에 값이 있는 그래프 (이동 비용)
    </br></br>

- 완전 그래프
  - 모든 정점이 서로 연결되어 있는 그래프
  - 정점이 N개일 경우, 간선의 수는 n(n-1)/2 개

> 그래프 탐색 ( DFS - Depth First Search )
- 각 노드에 방문했는지 여부를 체크할 배열과 스택을 이용하여 구현

> 그래프 탐색 ( BFS - Breath First Search )
- 각 노드에 방문했는지 여부를 체크할 배열과 큐(FIFO)를 이용하여 구현

>그래프의 구현
- 인접 행렬(Adjacency Matrix)
  - 2차원 배열 이용
- 인접 행렬의 장단점
  - 간선 정보 확인과 업데이트가 빠름 O(1)
  - 인접 행렬을 위한 메모리 공간 차지
    </br></br>
- 인접 리스트(Adjacency List)
  - 연결 리스트 이용
- 인접 행렬의 장단점
  - 메모리 사용량이 상대적으로 적고, 노드의 추가 삭제 빠름
  - 간선 정보 확인이 상대적으로 오래걸림

> 인접 행렬 vs 인접 리스트
- 인접 행렬
  - 노드의 개수가 적고 간선의 수가 많을 때 유리 (밀집 그래프)
- 인접 리스트
  - 노드의 개수가 많고 간선의 수가 적을 때 유리 (희소 그래프)

|             |  인접 행렬   |     인접 리스트     |
|:-----------:|:--------:|:--------------:|
|  특정 간선 검색   |   O(1)   |  O(degree(V))  |
|  정점의 차수 계산  |   O(N)   |  O(degree(V))  |
|  전체 노드 탐색   |  O(N^2)  |      O(E)      |
|     메모리     |  N X N   |     N + E      |
N : 전체 정점 개수</br>
E : 전체 간선 개수