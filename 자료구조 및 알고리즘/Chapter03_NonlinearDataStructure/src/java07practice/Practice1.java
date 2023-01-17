package java07practice;

//DFS 사용
//visited 만들어놓고 이동할 수 있는 위치 4방향 정하기
//for문 돌면서 dfs 탐색
public class Practice1 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //오른 위 아래 왼

    public static boolean solution(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int x, int y, int i, String word) {
        int row = board.length;
        int col = board[0].length;

        if (i == word.length()) {
            return true;
        }

        //배열 범위에서 나감
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }
        //해당 위치의 문자가 word의 해당위치의 값과 다를 때
        if (board[x][y] != word.charAt(i)) {
            return false;
        }

        visited[x][y] = true;

        for (int[] dir : dirs) { //네방향 회전
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            if (dfs(board, visited, xNext, yNext, i + 1, word)) {
                return true;
            }
        }
        visited[x][y] = false; //어디로가도 안됨
        return false;
    }

    public static void main(String[] args) {
        //TestCode
        char[][] board = {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution(board, "ABCCED"));
        System.out.println(solution(board, "SEE"));
        System.out.println(solution(board, "ABCB"));
    }
}
