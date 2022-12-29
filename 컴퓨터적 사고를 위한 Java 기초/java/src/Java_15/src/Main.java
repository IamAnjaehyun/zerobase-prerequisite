package Java_15.src;// Java 프로그래밍 - 컬렉션 프레임워크
// 여러 데이터를 편리하게 관리할 수 있게 만들어놓은 것 - 자료구조 및 알고리즘을 구조화
// 대표 인터페이스
// List - 순서O , 데이터 중복O , ex) ArrayList, LinkedList, Vector
// Set - 순서X , 데이터 중복X, ex) HashSet, TreeSet
// Map - 키와 쌍으로 이루어짐, 순서X, ex) HashMap, TreeMap
import java.util.*;

public class Main {

    public static void main(String[] args) {

//      1. List
//        1-1. ArrayList
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println("list1 = " + list1);
        list1.remove(Integer.valueOf(2));
        System.out.println("list1 = " + list1);
        list1.add(0, 10);
        System.out.println("list1 = " + list1);
        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.contains(1) = " + list1.contains(1));
        System.out.println("list1.indexOf(10) = " + list1.indexOf(10));

//      1-2. LinkedList
        System.out.println("== LinkedList ==");



//      2. Set
//      2-1. HashSet
        System.out.println("== HashSet ==");


//      2-2. TreeSet
        System.out.println("== TreeSet ==");



//      3. Map
//      3-1. HashMap
        System.out.println("== HashMap ==");
        HashMap map1 = new HashMap();
        map1.put(1, "kiwi");
        map1.put(2, "apple");
        map1.put(3, "mango");
        System.out.println("map1 = " + map1);
        
        map1.remove(2);
        System.out.println("map1 = " + map1);
        System.out.println("map1.get(1) = " + map1.get(1));


//      3-2. TreeMap
        System.out.println("== TreeMap ==");


    }
}
