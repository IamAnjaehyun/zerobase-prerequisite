package Java_13_1.src;// Java 프로그래밍 - 입출력_1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void referInputStream() throws IOException {
//      System.in
//        System.out.println("== System.in ==");
//        System.out.print("입력 : ");
//        int a = System.in.read() - '0'; //ascii 값 만큼 빼서 숫자로 만들어줌
//        System.out.println("a = " + a);
//        System.in.read(new byte[System.in.available()]); // enter key 남아있으니까 꼭 빼기

//      InputStreamReader
//        System.out.println("== InputStreamReader ==");
//        InputStreamReader reader = new InputStreamReader(System.in);
//        char[] c = new char[3];
//        System.out.print("입력 : ");
//        reader.read(c);
//        System.out.println(c);

//      BufferedReader
//        System.out.println("== BufferedReader ==");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("입력 : ");
//        String s1 = br.readLine();
//        System.out.println("s1 = " + s1);
    }

    public static void main(String[] args) throws IOException {

//      1. 입력
//      1-1. 다른 입력 방식 참고
//        referInputStream();

//      1-2. Scanner
//        System.out.println("== Scanner ==");
//        Scanner sc = new Scanner(System.in);
//        System.out.print("입력 sc.next : " );
//        System.out.println(sc.next());
//        sc.nextLine(); //엔터키 소진

//        System.out.print("입력 sc.nextInt : ");
//        System.out.println(sc.nextInt());
//        sc.nextLine();//엔터키 소진

//        System.out.print("입력 sc.nextLine : ");
//        System.out.println(sc.nextLine());
////      참고) 정수, 문자열 변환
//        int num = Integer.parseInt("12345");
//        String str = Integer.toString(12345);

//      2. 출력
        System.out.println("== 출력 ==");
        System.out.println("println hello");
        System.out.println("world!");

        System.out.print("print hello ");
        System.out.print("world!");
        System.out.println();

        System.out.printf("printf hello ");
        System.out.printf("world!");
        System.out.println();

        String s = "자바";
        int number = 3;
        System.out.println(s + "는 언어 선호도 " + number + "위 입니다.");
        System.out.printf("%s는 언어 선호도 %d위 입니다.\n", s, number);

        System.out.printf("정수형 %d\n", 10);
        System.out.printf("8진수 %o\n", 10);
        System.out.printf("16진수 %x\n", 10);

        System.out.printf("실수 %f\n", 5.2f);

        System.out.printf("문자값 %c\n", 'A');
        System.out.printf("문자열 %s\n", "문자열 출력한다.");

        System.out.printf("%5d\n", 123);
        System.out.printf("%5d\n", 1234);
        System.out.printf("%5d\n", 12345);
        System.out.println();

        System.out.printf("%-5d\n", 123);
        System.out.printf("%-5d\n", 1234);
        System.out.printf("%-5d\n", 12345);
        System.out.println();

        System.out.printf("소숫점(자동 반올림) %.2f\n", 1.1264567);

    }
}
