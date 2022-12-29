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
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println("list2 = " + list2);
        list2.addFirst(10);
        list2.addLast(20);
        System.out.println("list2 = " + list2);
        list2.remove(1);
        System.out.println("list2 = " + list2);
        list2.remove(Integer.valueOf(2));
        System.out.println("list2 = " + list2);
        list2.removeFirst();
        list2.removeLast();
        System.out.println("list2 = " + list2);
        System.out.println("list2.size() : " + list2.size());




//      2. Set
//      2-1. HashSet
        System.out.println("== HashSet ==");
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        System.out.println("1,2,3 추가 hashSet = " + hashSet);
        hashSet.remove(1);
        System.out.println(".remove(1) hashSet = " + hashSet);
        hashSet.add(2);
        hashSet.add(3);
        System.out.println("중복 불가능한 hashSet = " + hashSet);
        System.out.println("size() : " + hashSet.size());
        System.out.println("2포함 ? : " +hashSet.contains(2));


//      2-2. TreeSet
        System.out.println("== TreeSet ==");
        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        System.out.println("1,2,3 treeSet = " + treeSet);
        treeSet.remove(2);
        System.out.println(".remove(2) treeSet = " + treeSet);
        treeSet.clear();
        System.out.println("clear() treeSet = " + treeSet);
        treeSet.add(10);
        treeSet.add(15);
        treeSet.add(5);
        treeSet.add(15);
        System.out.println("10,15,5,15 추가 중복안됨 treeSet = " + treeSet);
        System.out.println("first() : " + treeSet.first());
        System.out.println("last() : " + treeSet.last());
        System.out.println("lower(10) ~보다 작은거 : " + treeSet.lower(10));
        System.out.println("higher(10) ~보다 큰거 : " + treeSet.higher(10));


//      3. Map
//      3-1. HashMap
        System.out.println("== HashMap ==");
        HashMap map1 = new HashMap();
        map1.put(1, "kiwi");
        map1.put(2, "apple");
        map1.put(3, "mango");
        System.out.println("1,'kiwi'  ,  2,'apple'  ,  3,'mango' map1 = " + map1);
        
        map1.remove(2);
        System.out.println("remove(2) map1 = " + map1);
        System.out.println("map1.get(1) = " + map1.get(1));


//      3-2. TreeMap
        System.out.println("== TreeMap ==");
        TreeMap treeMap = new TreeMap();
        treeMap.put(10,"kiwi");
        treeMap.put(5,"apple");
        treeMap.put(15,"mango");
        System.out.println("treeMap = " + treeMap);

        System.out.println("firstEntry() treeMap = " + treeMap.firstEntry());
        System.out.println("firstKey() treeMap = " + treeMap.firstKey());
        System.out.println("lastEntry() treeMap = " + treeMap.lastEntry());
        System.out.println("lastKey() treeMap = " + treeMap.lastKey());
        System.out.println("lowerEntry treeMap = " + treeMap.lowerEntry(10));
        System.out.println("higherEntry treeMap = " + treeMap.higherEntry(10));

    }
}
