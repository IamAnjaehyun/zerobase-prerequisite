package java09practice2_1;
//카탈랑 수열
//F(n+1) = F(i)F(n-i)
//= F(n) = F(i)F(n-1-i)
public class Practice1 {
    public static int solution(int n){
        int result = 0;

        if(n<=1){
            return 1;
        }

        for(int i=0;i<n;i++){
            result += solution(i)*solution(n-i-1);
        }
        return result;
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
