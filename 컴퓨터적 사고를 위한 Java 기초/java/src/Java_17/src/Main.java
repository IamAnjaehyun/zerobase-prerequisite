package Java_17.src;// Java 프로그래밍 - 스트림
// 배열, 컬렉션 등의 데이터를 하나씩 참조하여 처리 가능한 기능
// for문의 사용을 줄여 코드를 간결하게 함
// stream 은 크게 3가지로 구성 - Stream 생성 / 중개 연산 / 최종 연산

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//      1. 스트림 생성

//      1-1. 배열 스트림
        System.out.println("== 배열 스트림 == ");
        String[] arr = new String[]{"a", "b", "c"};

        System.out.println("== for i ==");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("== forEach ==");
        for (String item : arr) {
            System.out.println(item);
        }

        System.out.println("== to Stream ==");
        Stream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);


//      1-2. 컬렉션 스트림
        System.out.println("== 컬렉션 스트림 ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("list1 = " + list1);

        System.out.println("== to Stream ==");
        Stream stream1 = list1.stream();
//        stream1.forEach(System.out::println); // stream은 최종연산을 만나면 더이상 스트림 연산 못하고 종료됨
        stream1.forEach(num -> System.out.println("num = " + num));


//      1-3. 스트림 builder
        System.out.println("== 스트림 builder ==");
        Stream streamBuilder = Stream.builder().add(1).add(2).add(3).build();
        streamBuilder.forEach(System.out::println);

//      1-4. 스트림 generate
        System.out.println("== 스트림 generate ==");
        Stream streamGenerate = Stream.generate( () -> "abc").limit(3); //"abc" 를 3번 반복해서 만들어줌
        streamGenerate.forEach(System.out::println);


//      1-5. 스트림 iterate
        System.out.println("== 스트림 iterate ==");
        Stream streamIterate = Stream.iterate(10, n -> n*2).limit(3); //초기값 10을 n*2시키는데 3번반복시킴 10,20,40
        streamIterate.forEach(System.out::println);

//      1-6. 기본 타입 스트림
        System.out.println("== 기본타입 스트림 ==");
        IntStream intStream = IntStream.range(1,5); // range(1,5) 는 1~4까지 생성 / 끝 포함하려면 rangeClosed
        intStream.forEach(System.out::println);


//      2. 스트림 중개 연산

//      2-1. Filtering
        System.out.println("== Filtering ==");
        IntStream intStream2 = IntStream.range(1,10).filter(n -> n%2 == 0);
        intStream2.forEach(System.out::println); //2 4 6 8

//      2-2. Mapping
        System.out.println("== Mapping ==");
        IntStream intStream3 = IntStream.range(1,10).map(n -> n+1);
        intStream3.forEach(n -> System.out.print(n + " ")); //2 3 4 5 6 7 8 9 10
        System.out.println();

//      2-3. Sorting
        System.out.println("== Sorting ==");
        IntStream intStream4 = IntStream.builder().add(5).add(1).add(3).add(4).add(2).build();
        IntStream intStreamSort = intStream4.sorted();
        intStreamSort.forEach(System.out::println); // 1 2 3 4 5로 sorting

//      3. 최종 연산

//      3-1. Sum, Average
        System.out.println("== sum, average ==");
        int sum = IntStream.range(1,5).sum();
        System.out.println("sum = " + sum);
        double average = IntStream.range(1,5).average().getAsDouble(); //getAsDouble 써야함
        System.out.println("average = " + average);

//      3-2. Min, Max
        System.out.println("== min, max ==");
        int min = IntStream.range(1,5).min().getAsInt(); //getAsInt로 int 값으로 가져옴
        System.out.println("min = " + min);
        int max = IntStream.range(1,5).max().getAsInt(); //getAsInt로 int 값으로 가져옴
        System.out.println("max = " + max);


//      3-3. reduce
        System.out.println("== reduce ==");
        Stream<Integer> stream3 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)).stream();
        System.out.println(stream3.reduce((x,y) -> x+y).get()); // 1~5까지 더하기 map이랑 유사 reduce는 연쇄적으로 더함 1+2 -> 3+3 -> dlfjstlr

//      3-4. forEach
        System.out.println("== forEach == ");
        // 1에서 10까지 데이터 만들어서 넣고 5인 데이터 forEach 돌려서 뽑아오기
        IntStream.range(1,10).filter(n -> n==5).forEach(System.out::println);


    }
}


