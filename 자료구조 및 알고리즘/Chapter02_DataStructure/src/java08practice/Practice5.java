package java08practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice5 {
    public static Integer solution(int n, int k, int l, ArrayList<ArrayList> apples, Queue<ArrayList> moves) {
        int[][] board = new int[n + 1][n + 1]; //충돌 편하ㅑ게 처리하기 위함
        for (ArrayList item : apples) {
            board[(int) item.get(0)][(int) item.get(1)] = 1;
        }
        Queue<ArrayList> snake = new LinkedList<>();
        snake.add(new ArrayList(Arrays.asList(1, 1)));

        ArrayList<ArrayList> direction = new ArrayList<>();
        direction.add(new ArrayList(Arrays.asList(0, 1))); //행 열 오른쪽방향
        direction.add(new ArrayList(Arrays.asList(1, 0))); //행 열 행쪽 아래
        direction.add(new ArrayList(Arrays.asList(0, -1)));//행 열 열쪽 좌측
        direction.add(new ArrayList(Arrays.asList(-1, 0)));//행 열 행쪽 위로

        int dIdx = 0;
        int score = 0;
        int x = 1;
        int y = 1;

        while (true) {
            score += 1;
            x += (int) direction.get(dIdx).get(0);
            y += (int) direction.get(dIdx).get(1);

            if (1 <= x && x <= n && 1 <= y && y <= n) {
                ArrayList cur = new ArrayList(Arrays.asList(x, y));
                if (snake.contains(cur)) { //몸과 부딪힘
                    return score;
                }
                snake.add(cur);

                if (board[x][y] == 0) { //사과있음
                    snake.poll();
                } else {
                    board[x][y] = 0;
                }
            } else {
                return score;
            }
            //이동방향 바꿈
            if (moves.size() > 0 && score == (int) moves.peek().get(0)) {//3초후에 대한 값이 같으면 위치정보 가져온거
                if ((char) moves.peek().get(1) == 'D') {
                    dIdx = (dIdx + 1) % 4; //90도 순서로 위에서 작성해둠
                    moves.poll();

                } else if ((char) moves.peek().get(1) == 'L') {
                    dIdx = (dIdx - 1) % 4;
                    moves.poll();
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int l = 3;
        ArrayList<ArrayList> apples = new ArrayList<>();
        apples.add(new ArrayList<>(Arrays.asList(3, 4)));
        apples.add(new ArrayList<>(Arrays.asList(2, 5)));
        apples.add(new ArrayList<>(Arrays.asList(5, 3)));

        Queue<ArrayList> moves = new LinkedList<>(); //먼저넣은 정보 먼저 나옴
        moves.add(new ArrayList(Arrays.asList(3, 'D')));
        moves.add(new ArrayList(Arrays.asList(15, 'L')));
        moves.add(new ArrayList(Arrays.asList(7, 'D')));
        System.out.println(solution(n, k, l, apples, moves));

        n = 10;
        k = 4;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 4)));
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println(solution(n, k, l, apples, moves));

        n = 10;
        k = 5;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 6)));
        apples.add(new ArrayList<>(Arrays.asList(1, 7)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println(solution(n, k, l, apples, moves));


    }
}
