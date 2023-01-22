package java09backtracking;
//Practice3
//sols 배열에 5지 선다 문제의 정답들이 적혀있다.
//3번 연속 해서 같은 정답이 있는 경우가 없다는 것을 알아낸 후,
//문제를 찍어서 푼다고 할 때, 5점 이상 받을 경우의 수를 출력하세요.

//문제는 총 10문제이며 각 문제당 1점이다.

//입출력 예시
//sols : {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
//결과 : 261622
public class Practice3 {
    public static int numOfProblems = 10;
    static int cnt;

    public static void solution(int[] sols) {
        if (sols == null || sols.length != numOfProblems) {
            return;
        }

        cnt = 0;
        int[] submit = new int[numOfProblems];
        //backTracking 5점 넘었는지 확인
        backTracking(sols, submit, 0, 0);
        System.out.println(cnt);

    }

    public static void backTracking(int[] sols, int[] submit, int correctCnt, int idx) {
        if (numOfProblems - idx + correctCnt < 5) { //어차피 5점 못넘음 끊음
            return;
        }
        if (idx == numOfProblems) {
            if (correctCnt >= 5) {
                cnt += 1;
            }
        } else {
            int towInRow = 0; //같은값을 두번 썼을 때 체크할 변수
            if (idx >= 2) { //두문제 이상 푼 상황에서
                if (submit[idx - 1] == submit[idx - 2]) { //전문제, 전전문제 답이 같으면 다음에 적을필요 없음
                    towInRow = submit[idx - 1]; //연속 두개면 다음에 같은값 나오지 않도록
                }
            }
            for (int i = 1; i <= 5; i++) {
                if (i == towInRow) {
                    continue;
                }

                submit[idx] = i;
                if (sols[idx] == i) {
                    backTracking(sols, submit, correctCnt + 1, idx + 1); //맞은개수 늘려나가면서 백트래킹
                } else {
                    backTracking(sols, submit, correctCnt, idx + 1); //틀린다음 백트래킹
                }
                submit[idx] = 0;
            }
        }
    }

    public static void main(String[] args) {
        //TestCode
        int[] sols = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        solution(sols);

        sols = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        solution(sols);
    }
}
