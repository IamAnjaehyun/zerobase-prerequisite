package java02binarysearchtree;
//Practice8
//주어진 BST에서 두 노드의 합이 target 값이 되는 경우가 있는지 확인하세요.
//있으면 true, 없으면 false 반환

//입력 트리    : 5, 3, 6, 2, 4, null, 7
//target     : 9
//결과        : ture

import java.util.HashSet;

//입력 트리    : 5, 3, 6, 2, 4, null, 7
//target     : 28
//결과        : false
public class Practice8 {
    public static void solution(Integer[] data, int target) {

        BinarySearchTree6 bst = new BinarySearchTree6(data[0]);

        for (int i = 1; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }
            bst.addNode(data[i]);
        }
        HashSet<Integer> set = new HashSet<>();
        boolean result = search(bst.head, set, target);
        System.out.println(result);
    }

    public static boolean search(Node6 node6, HashSet<Integer> set, int target){
        if(node6 == null){
            return false;
        }

        if(set.contains(target - node6.key)){ //ex) ta 9 / 현재 4 라면 set에 5가 있는지 찾음
            return true;
        }
        set.add(node6.key);

        if(search(node6.left, set, target)){
            return true;
        }

        if(search(node6.right, set, target)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        //TestCode
        Integer[] data = {5, 3, 6, 2, 4, null, 7};
        int target = 9;
        solution(data, target);

        data = new Integer[]{5, 3, 6, 2, 4, null, 7};
        target = 28;
        solution(data, target);
    }
}
