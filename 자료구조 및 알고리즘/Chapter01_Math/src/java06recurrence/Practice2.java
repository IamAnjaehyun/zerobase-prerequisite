package java06recurrence;
//Practice2
//최대공약수를 재귀함수로 구하시오
public class Practice2 {
    static int gcd(int a,int b){
        if(a%b ==0){
            return b;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println("gcd : " + gcd(3,5));
        System.out.println("gcd : " + gcd(2,6));
        System.out.println("gcd : " + gcd(8,12));
        System.out.println("gcd : " + gcd(5,15));
    }

}
