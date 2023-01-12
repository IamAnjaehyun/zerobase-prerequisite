package java01tree;

//각각의 에지에 가중치가 있는 포화 이진 트리가 있다.
//루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
//이 떄, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요
class BinaryTree5 {
    int h;
    int[] arr;
    int res;

    public BinaryTree5(int h, int[] w) {
        this.h = h;
        arr = new int[(int) Math.pow(2, h + 1)]; //하나는 안씀 인덱스 1부터 시작
        res = 0; //결과

        //인덱스는 1부터 시작하고, 맨위 루트노드는 사용 안해서 2부터 시작
        for (int i = 2; i < (int) Math.pow(2, h + 1); i++) {
            arr[i] = w[i - 2];
        }
    }

    public int dfs(int idx, int h) {
        if (this.h == h) {
            res += arr[idx];
            return arr[idx];
        }

        int left = dfs(idx * 2, h + 1);
        int right = dfs(idx * 2 + 1, h + 1);
        res += arr[idx] + Math.abs(left - right);
        return arr[idx] + Math.max(left, right);
    }
}

public class Practice5 {
    public static void solution(int h, int[] w) {
        BinaryTree5 bt = new BinaryTree5(h,w);
        bt.dfs(1,0);
        System.out.print(bt.res);
    }

    public static void main(String[] args) {
        //TestCode
        int h = 2; //트리의 높이
        int[] w = {2, 2, 2, 1, 1, 3}; //트리에서 각각 에지의 가중치
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1};
        solution(h, w);
    }
}
