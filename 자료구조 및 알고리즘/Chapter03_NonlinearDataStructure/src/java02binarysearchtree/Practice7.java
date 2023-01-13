package java02binarysearchtree;
//Practice7
//주어진 BST에서 인접한 노드 간의 차이값 중 최소를 구하세요.

//입력 트리 : 4, 2, 6, 1, 3
//출력 : 1

//입력 트리 : 5, 1, 48, null, null, 12, 51
//출력 : 3

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
- 전위 순회(PreorderTraversal)
- 방문 순서 : 현재 노드 -> 왼쪽노드 -> 오른쪽 노드
- 중위 순회(InorderTraversal)
- 방문 순서 : 왼쪽 노드 -> 현재노드 -> 오른쪽 노드
- 전위 순회(PostorderTraversal)
- 방문 순서 : 왼쪽 노드 -> 오른쪽 노드 -> 현재 노드
- 레벨 순회(LevelorderTraversal)
- 방문 순서 : 위쪽 레벨 부터 왼쪽 노드 -> 오른쪽 노드
 */
public class Practice7 { //levelOrder 방식 이용
    public static void solution(Integer[] data) {
        BinarySearchTree6 bst = new BinarySearchTree6(data[0]);

        for (int i = 1; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }
            bst.addNode(data[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        levelOrder(bst.head, list);
//        int min = list.stream().min((x1, x2) -> x1 > x2 ? 1 : -1).get(); //데이터 뽑아서 정수형으로 반환
        int min = Collections.min(list);

        System.out.println(min);
    }

    public static void levelOrder(Node6 node6, ArrayList<Integer> list) {
        Queue<Node6> queue = new LinkedList<>();
        queue.add(node6);

        while (!queue.isEmpty()) {
            Node6 cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
                //차이값 계산해서 list에 넣어줌
                list.add(Math.abs(cur.key - cur.left.key));
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                list.add(Math.abs(cur.key - cur.right.key));

            }

        }
    }

    public static void main(String[] args) {
        //TestCode
        Integer[] data = {4, 2, 6, 1, 3};
        solution(data);

        data = new Integer[]{5, 1, 48, null, null, 12, 51};
        solution(data);
    }
}
