package java04twopointers;
//Practice3
//문자열 s를 거꾸로 출력하는 프로그램을 작성하세요.
//단, 각 단어의 알파벳 순서는 그대로 출력합니다.
//문장에 공백이 여러개일 시, 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거하세요.

//입출력 예시
//문자열 s : "the sky is blue"
//출력 : "blue is sky the"

//문자열 s : "  hello        java   "
//출력 : "java hello"
public class Practice3 {
    public static String solution(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() < 2) {
            return s;
        }

        //공백제거
        s = removeSpaces(s);
        char[] cArr = s.toCharArray();
        reverseString(cArr, 0, s.length() - 1);
        reverseWords(cArr, s.length());

        return new String(cArr);
    }

    //공백 제거
    public static String removeSpaces(String s) {
        int p1 = 0;
        int p2 = 0;

        char[] cArr = s.toCharArray();
        int length = s.length();

        while (p2 < length) {
            while (p2 < length && cArr[p2] == ' ') { //해당 문자열에서 앞쪽에 공백이 있을 경우
                p2++;
            }
            while (p2 < length && cArr[p2] != ' ') { //중간에 공백이 아닐 때 채워넣고
                cArr[p1++] = cArr[p2++];
            }
            while (p2 < length && cArr[p2] == ' ') { //문자 뒤로 공백이 있을 때 p2 지나가는 상황
                p2++;
            }

            if (p2 < length) { //단어와 단어 사이에만 공백
                cArr[p1++] = ' ';
            }
        }

        return new String(cArr).substring(0, p1);
    }

    //뒤집기
    public static void reverseString(char[] cArr, int i, int j) {
        while (i < j) {
            char temp = cArr[i];
            cArr[i++] = cArr[j];
            cArr[j--] = temp;
        }
    }

    public static void reverseWords(char[] cArr, int length) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < length) {
            while (p1 < p2 || p1 < length && cArr[p1] == ' ') {
                p1++;
            }
            while (p2 < p1 || p2 < length && cArr[p2] != ' ') {
                p2++;
            }
            reverseString(cArr, p1, p2 - 1);
        }
    }

    public static void main(String[] args) {
        //TestCode
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello        java   "));
    }
}
