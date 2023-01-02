package java07exponential_logarithmic;

//제곱 같은수를 두번 곱합
//거듭제곱 같은 수를 거듭하여 곱함
public class Main {
    public static void main(String[] args) {

        // 1.제곱, 제곱근, 지수
        System.out.println("==제곱==");
        System.out.println(Math.pow(2,3));
        System.out.println(Math.pow(2,-3));
        System.out.println(Math.pow(-2,-3));
        System.out.println(Math.pow(-2,-4));
        System.out.println(Math.pow(2,30));
        System.out.printf("%.0f",Math.pow(2,30));

        System.out.println();


        System.out.println("==제곱근==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.pow(16, 1.0/2));
        System.out.println(Math.pow(16, 1.0/4));


        System.out.println("==절대값==");
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));

        System.out.println("==로그==");
        System.out.println("자연상수 : " + Math.E);
        System.out.println(Math.log(2.718281828459045));
        System.out.println(Math.log10(1000));
        System.out.println("log2 4: " +Math.log(4)/Math.log(2));

    }
}
