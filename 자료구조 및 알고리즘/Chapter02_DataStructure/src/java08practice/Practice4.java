package java08practice;

import java.util.HashMap;
import java.util.Stack;

public class Practice4 { //순서도 생각 해야함
    public static void solution(String str){
        Stack<String> stack = new Stack<>();
        boolean checkFlag = true;

        HashMap<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");


        for(String x :  str.split("")){
            if(map.containsKey(x)){
                stack.push(x);
            }else if(map.containsValue(x)){
                if(stack.isEmpty()){
                    checkFlag = false;
                    break;
                }else {
                    String cur = stack.pop();
                    if(!x.equals(map.get(cur))){
                        checkFlag = false;
                        break;
                    }
                }
            }
        }

        if(checkFlag && stack.isEmpty()){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }
    public static void main(String[] args) {

        solution("[yyyy]-[mm]-[dd]");
        solution("System.out.println(arr[0][1))");
        solution("Support [Java or Python(3.x)]");
        solution("([[{}])");

    }
}
