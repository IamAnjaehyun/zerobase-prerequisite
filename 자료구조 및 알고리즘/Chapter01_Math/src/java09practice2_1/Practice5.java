package java09practice2_1;

//하노이의 탑
//한번에 한개의 원판만 옮길수 있으며, 큰원판이 작은 원판 위에 있으면 안된다.
public class Practice5 {
    static StringBuffer sb;

    public static void solution(int n) {
        sb = new StringBuffer();

        hanoi(n, 1, 2, 3); //초기원판 개수 (시작 중간 끝)
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) { //원판 갯수, 시작기둥, 중간기둥, 목표기둥
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        hanoi(n - 1, start, to, mid); //to 와 mid 자리를 바꿔주는거임

        sb.append(start + " " + to + "\n"); //다음원판은 다음 위치로 이동

        hanoi(n - 1, mid, start, to); // 자리 바꾸기

    }

    public static void main(String[] args) {
        //TestCode
        solution(2);
        System.out.println();

        solution(3);
        System.out.println();

        solution(4);
        System.out.println();
    }
}
