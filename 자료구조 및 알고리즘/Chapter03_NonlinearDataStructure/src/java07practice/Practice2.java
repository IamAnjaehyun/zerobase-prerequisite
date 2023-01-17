package java07practice;

//외곽 부분이 O인지 찾아보고 O인 부분이 있으면 그 부분만 찾아서 dfs진
public class Practice2 {

    public static void solution(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        //외곽에서 dfs 시작
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') { //오곽 O로 시작
                dfs(board, i, 0); //행쪽이 바뀜, 좌측 외곽에서 비교
            }

            if (board[i][col - 1] == 'O') { //오른쪽 끝쪽
                dfs(board, i, col - 1);
            }
        }

        for (int i = 0; i < col - 1; i++) {
            if (board[0][i] == 'O') {//행쪽 고정
                dfs(board, 0, i);
            }

            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 'O'){ // > 'X'로 둘러싸여있음
                    board[i][j] ='X';
                }
                if(board[i][j] == '*'){
                    board[i][j] ='O';

                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y) {
        if(x<0 || y<0 || x > board.length-1 || y> board.length-1){ //범위 초과
            return;
        }

        if(board[x][y] != 'O'){ //'X'만남
            return;
        }

        board[x][y] = '*';
        dfs(board,x+1, y); //오른쪽
        dfs(board,x-1, y); //왼쪽
        dfs(board,x, y+1); //아래쪽
        dfs(board,x, y-1); //위쪽

    }

    public static void main(String[] args) {
        //TestCode
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("===========================");

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
