package Java_02_3.src;// Java 프로그래밍 - 변수와 자료형_3

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

//      1. 자료형 - 문자열
        System.out.println("== 문자열 ==");
        String s1 = "hello World";
        System.out.println("s1 = " + s1);
        String s2 = "01234";
        System.out.println("s2 = " + s2);

//      1-1. equals
        String s3 = "Hi";
        String s4 = "Hi";
        System.out.println(s3.equals(s4));
        System.out.println(s3 == s4);
        //new String 은 새로 객체를 만들어줌
        String s5 = new String("Hi");
        //equals 는 값만 비교
        System.out.println(s3.equals(s5));
        // == 는 객체를 비교
        System.out.println(s3 == s5);

//      1-2. indexOf
        String s6 = "Hello! World!";
        System.out.println(s6.indexOf("!")); //첫 느낌표
        System.out.println(s6.indexOf("!", s6.indexOf("!")+1)); // ! 을 s6.indexOf("!") 하나 뒤에부터 찾아봐라

//      1-3. replace
        String s7 = s6.replace("Hello", "Bye");
        System.out.println("s7 = " + s7);

//      1-4. substring
        System.out.println(s7.substring(0,3)); //0부터 3하나전까지 출력
        System.out.println(s7.substring(0, s7.indexOf("!") + 1)); //느낌표까지만 출력


//      1-5. toUpperCase
        System.out.println(s7.toUpperCase());


//      2. 자료형 - StringBuffer
        System.out.println("== StringBuffer ==");
        // 문자열 수정 잦을땐 버퍼쓰기, 데이터가 변경되어도 객체가 새로 생성되지 않음. 그래서 StringBuffer가 좋음
        StringBuffer sb1 = new StringBuffer();
        sb1.append("01234");
        System.out.println("sb1 = " + sb1);
        sb1.append("56789");
        System.out.println("sb1 = " + sb1);

        String a = "01234";
        String b = "56789";
        String bak = a;
        System.out.println(a == bak);

        a+=b;
        System.out.println("a = " + a);
        //다른 객체라 false 나옴
        System.out.println(a==bak);

//      3. 자료형 - 배열
        System.out.println("== 배열 ==");
        int[] myArray1 = {1,2,3,4,5};
        System.out.println(myArray1[0]);
        System.out.println(myArray1[1]);
        System.out.println(myArray1[2]);
        System.out.println(myArray1[3]);
        System.out.println(myArray1[4]);

        char[] myArray2 = {'a','b','c','d','e'};
        System.out.println(myArray2[3]);

        String[] myArray3 = new String[3];
        myArray3[0] = "Hello";
        myArray3[1] = " ";
        myArray3[2] = "World";
        System.out.println(myArray3[0] + myArray3[1] + myArray3[2]);

    }
}
