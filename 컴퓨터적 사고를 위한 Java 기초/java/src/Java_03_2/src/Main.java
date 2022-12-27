package Java_03_2.src;// Java 프로그래밍 - 여러가지 연산자_2

public class Main {
    public static void main(String[] args) {

//      1. 비트 논리 연산자
        System.out.println("== 비트 논리 연산자 ==");
//      1-1. AND 연산자 (&) 두 개의 비트 값이 모두 1인 경우에만 결과 1
        System.out.println("=== & ===");
        int num1 = 5;
        int num2 = 3;
        int result = 0;

        result = num1 & num2;
        System.out.println("result = " + result);
        System.out.println(Integer.toBinaryString(num1));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라

//      1-2. OR 연산자 (|) 두 개의 비트 값 중 하나라도 1이면 결과 1
        System.out.println("=== | ===");

        result = num1 | num2;

        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라


//      1-3. XOR 연산자 (^) 두 개의 비트값이 같으면 0 , 다르면 1
        System.out.println("=== XOR ===");

        result = num1 ^ num2;

        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라


//      1-4. 반전 연산자 (~) 비트 값이 0이면 1로, 1이면 0으로 반전
        System.out.println("=== ~ ===");
        num1 = 5;

        result = ~num1;

        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%s\n", Integer.toBinaryString(result)); //byte체계가 32자리라 앞에 싹다 1

//      2. 비트 이동 연산자
        System.out.println("== 비트 이동 연산자 ==");
//      2-1. << 연산자 비트를 왼쪽으로 이동
        int numA = 3;
        result = numA << 1;

        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라


//      2-2. >> 연산자 비트를 오른쪽으로 이동

        result = numA >> 1;

        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result))); //4개자리로 채우는데 앞자리 모자르면 0으로 채워라

//      2-3. >>> 연산자 비트를 오른쪽으로 이동(부호비트 상관 없이 0으로 채움)
        numA = -5;
        result = numA >> 1;

        System.out.printf("%s\n", Integer.toBinaryString(numA));
        System.out.printf("%s\n", Integer.toBinaryString(result)); 

        result = numA >>> 1;
        System.out.printf("%s\n", Integer.toBinaryString(numA));
        System.out.printf("%s\n", Integer.toBinaryString(result)); //가장 앞에 빈 비트는 0으로 채움

    }

}
