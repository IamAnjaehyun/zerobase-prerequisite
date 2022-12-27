package Java_02_4.src;// Java 프로그래밍 - 변수와 자료형_4

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//      1. 자료형 - 리스트
        System.out.println("== 리스트 ==");
        ArrayList l1 = new ArrayList();

//      1-1. add
        l1.add(1);
        l1.add("hello");
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add("world!");
        System.out.println("l1 = " + l1);
        //l1 = [1, hello, 2, 3, 4, world!]

        l1.add(0,1); //0자리에 1추가
        System.out.println("l1 = " + l1);

//      1-2. get
        System.out.println(l1.get(0)); //0번 꺼내옴
        System.out.println(l1.get(3));

//      1-3. size
        System.out.println(l1.size()); //길이

//      1-4. remove
        System.out.println(l1.remove(0)); //0번자리 지워라
        System.out.println("l1 = " + l1);

        System.out.println(l1.remove(Integer.valueOf(2))); //숫자 2인 값을 지운다
        System.out.println("l1 = " + l1);

//      1-5. clear
        l1.clear(); //싹다 지워라
        System.out.println("l1 = " + l1);

//      1-6. sort
        ArrayList l2 = new ArrayList();
        l2.add(5);
        l2.add(3);
        l2.add(4);
        System.out.println("l2 = " + l2);

        l2.sort(Comparator.naturalOrder()); //오름차순
        System.out.println("l2 = " + l2);
        l2.sort(Comparator.reverseOrder()); //내림차순
        System.out.println("l2 = " + l2);

//      1-7. contains
        System.out.println(l2.contains(1)); //1있는지 false
        System.out.println(l2.contains(3)); //3있는지 ture



//      2. Maps
        System.out.println("== Maps ==");
        HashMap map = new HashMap();

//      2-1. put
        map.put("kiwi",9000);
        map.put("apple",10000);
        map.put("mango",12000);

        System.out.println("map = " + map);
        //map = {apple=10000, kiwi=9000, mango=12000}

//      2-2. get
        System.out.println(map.get("mandarine")); //null
        System.out.println(map.get("kiwi")); //9000

//      2-3. size
        System.out.println(map.size()); //3개
//      2-4. remove
        System.out.println(map.remove("kiwi")); //9000출력
        System.out.println(map.remove("mandarine"));
        System.out.println("map = " + map); //kiwi remove
//      2-5. containsKey
        System.out.println(map.containsKey("apple")); //true
        System.out.println(map.containsKey("kiwi")); //false

//      3. Generics
        //자료형을 제한해주는 기능
        System.out.println("== Generics ==");
        ArrayList l3 = new ArrayList();
        l3.add(1);
        l3.add("hello");
        System.out.println("l3 = " + l3);

        ArrayList<String> l4 = new ArrayList<>();
//        l4.add(1) //안됨 String 만 들어감
        l4.add("Hello");
        System.out.println("l4 = " + l4);

        HashMap map1 = new HashMap();
        map1.put(123, "id");
        map1.put("apple", 10000);

        HashMap<String,Integer> map2 = new HashMap<>();
//        map2.put(123, "id"); //String , Integer 형으로 들어가야함
        map2.put("apple", 10000);

        System.out.println("map2 = " + map2);

    }

}
