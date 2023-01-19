package java05greedy;
//Activity Selection Problem

import java.util.ArrayList;
import java.util.Collections;
class Activity{
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void selectActivity(ArrayList<Activity> list){
        Collections.sort(list, (x1,x2)-> x1.end - x2.end); //종료시간 기준 오름차순으로 정렬

        int curTime = 0; //현재 시간
        ArrayList<Activity> result = new ArrayList<>(); //결과값 담을 변수
        for(Activity item : list){      //활동 하나씩 가져옴
            if(curTime <= item.start){  //현재 시간이 시작 시간보다 작으면
                curTime = item.end;     // 엔드시간으로 바꿔주고
                result.add(item);       //하나씩 추가
            }
        }

        for(Activity item : result){
            System.out.print(item.name + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity("A",1,5));
        list.add(new Activity("B",4,5));
        list.add(new Activity("C",2,3));
        list.add(new Activity("D",4,7));
        list.add(new Activity("E",6,10));
        selectActivity(list);
    }
}
