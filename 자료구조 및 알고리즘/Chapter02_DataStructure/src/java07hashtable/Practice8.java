package java07hashtable;
//Practice8
//참고 - Hashtable? HashMap?

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Practice8 {
    public static void main(String[] args) {
        //HashTable
        Hashtable<Integer,Integer> hashTable = new Hashtable<>();
        hashTable.put(0,10);
        System.out.println(hashTable.get(0));

        //HashMap
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,10);
        System.out.println(hashMap.get(10));

        //다형성 이용
        Map<Integer,Integer> map1 = hashTable;
        Map<Integer,Integer> map2 = hashMap;
        System.out.println(map1.get(0));
        System.out.println(map2.get(0));

//        hashTable.put(null, -999);
//        System.out.println(hashTable.get(null)); //에러 발생

        hashMap.put(null, -999);
        System.out.println(hashMap.get(null)); //에러 발생X

        //HashTable 과 HashMap 차이
        //공통 : 둘 다 Map 인터페이스를 구현한 것
        //차이 :
        //key에 Null 사용 여부
            //HashTable:X
            //HashMap:O

            //Thread-safe
            //HashTable:O (멀티 스레드 환경에서 우수)
            //HashMap:X (싱글 스레드 환경에서 우수)
            //참고) synchronizedMap, ConcurrentHashMap
    }
}
