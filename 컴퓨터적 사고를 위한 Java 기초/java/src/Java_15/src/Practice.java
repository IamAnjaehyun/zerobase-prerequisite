package Java_15.src;// Practice
// 로또 번호 만들기

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Practice {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
        }
        LinkedList list = new LinkedList(set); //정렬을 위해
        Collections.sort(list);
        System.out.println("로또 번호 : " + list);
    }
}
