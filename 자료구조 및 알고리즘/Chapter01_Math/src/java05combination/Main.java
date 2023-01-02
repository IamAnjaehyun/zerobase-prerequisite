package java05combination;


public class Main {

    static int getCombinataion(int n, int r){
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }
        return pResult/rResult;
    }
    public static void main(String[] args) {
       // 조합 nCr = n! / (n-r)!r!
       // 서로다른 n개 중에서 r개를 선택하는 경우의 수(순서X 중복X) ex)서로다른 4명 중 주번 2명 뽑는 방법
        System.out.println("==조합==");
        int n = 4;
        int r = 2;

        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }
        System.out.println("결과 : " + pResult/rResult);

        // 중복 조합 nHr = n+r - 1Cr =
        // 서로다른 n개 중에서 r개를 선택하는 경우의 수(순서X 중복O) ex)후보 2명 유권자 3명일 때 무기명 투표 방법
        System.out.println("==중복조합==");
        n=2;
        r=3;

        System.out.println("결과 : "+ getCombinataion(n+r-1 , r));

    }
}
