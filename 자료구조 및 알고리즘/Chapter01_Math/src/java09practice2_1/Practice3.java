package java09practice2_1;

// 1차 방정식 풀이
public class Practice3 {
    public static String solution(String equation) {
        String[] parts = equation.split("="); //좌항 우항 분리
        int[] leftSide = evaluate2(parts[0]); //evaluate 하면 좌항에 X와 상수 하나만 남아있음
        int[] rightSide = evaluate2(parts[1]);//evaluate 하면 우항에 X와 상수 하나만 남아있음

//        int[] leftSide = evaluate1(parts[0]); //evaluate 하면 좌항에 X와 상수 하나만 남아있음
//        int[] rightSide = evaluate1(parts[1]);//evaluate 하면 우항에 X와 상수 하나만 남아있음

        if (leftSide[0] == rightSide[0] && leftSide[1] == rightSide[1]) {
            return "Infinite solution";
        } else if (leftSide[0] == rightSide[0]) {
            return "No Solution";
        } else {
            return "x=" + (rightSide[1] = leftSide[1] / (leftSide[0] - rightSide[0]));
        }

    }

    public static int[] evaluate(String str) {
        int[] result = new int[2];

        boolean isMinus = false;
        int idx = 0;
        while (idx != str.length()) {
            char c = str.charAt(idx++);

            if (c == '+') {
                continue;
            }

            if (c == '-') {
                isMinus = true;
                continue;
            }

            if (c == 'x') {
                result[0] += isMinus ? -1 : 1;
            } else {
                if (idx < str.length() && str.charAt(idx) == 'x') {
                    result[0] += isMinus ? -(c - '0') : (c - '0'); //c -'0' 은 자기 자신의 숫자값 나옴
                } else {
                    result[1] += isMinus ? -(c - '0') : (c - '0'); //c -'0' 은 자기 자신의 숫자값 나옴
                }
            }
            isMinus = false;
        }
        return result;
    }

    public static int[] evaluate2(String str) {
        int[] result = new int[2];

        for (String s : str.split("(?=[+-])")) {
            if (s.equals("+x") || s.equals("x")) {
                result[0]++;
            } else if (s.equals("-x")) {
                result[0]--;
            } else if (s.contains("x")) {
                result[0] += Integer.parseInt(s.substring(0, s.length() - 1));
            }else {
                result[1] += Integer.parseInt(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //TestCode
        String equation = "x+5-3+x=x-2";
        System.out.println(solution(equation));

        equation = "x=x";
        System.out.println(solution(equation));

        equation = "2x=x";
        System.out.println(solution(equation));
    }
}
