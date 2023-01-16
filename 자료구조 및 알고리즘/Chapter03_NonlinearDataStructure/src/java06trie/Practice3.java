package java06trie;
//Practice3
//문자열 배열 strs와 targets가 주어졌을 때
//targets 내의 단어 중 한 문자만 바꾸면 strs중의 단어가 되는지 판별하는 프로그램을 작성하세요.

//입출력 예시
//입력 strs : "apple", "banana", "kiwi"
//입력 targets : "applek", "bpple", "apple"
//출력 : true, ture ,false
public class Practice3 {
    public static void solution(String[] strs, String[] targets) {
        Trie1 trie = new Trie1();
        for (String str : strs) {
            trie.insert(str);
        }

        for (String target : targets) {
            boolean result = examineWord(trie.root, target, 0, false);
            System.out.print(result + " ");
        }
        System.out.println();
    }

    public static boolean examineWord(Node1 node, String target, int i, boolean flag) {
        if (i < target.length()) {
            if (node.child.containsKey(target.charAt(i))) {
                if (examineWord(node.child.get(target.charAt(i)), target, i + 1, flag)) {
                    return true;
                }
            }
            //같은거 들어오면 여기서 flag를 true로 바꿔주질 않으니 flag가 false라 false가 출력됨
            if (!flag) {
                for (char c : node.child.keySet()) {
                    //한 문자만 다르고 나머지는 true일 때
                    if (c != target.charAt(i) && examineWord(node.child.get(c), target, i + 1, true)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return flag && node.isTerminal;
    }

    public static void main(String[] args) {
        //TestCode
        String[] strs = {"apple", "banana", "kiwi"};
        String[] targets = {"applk", "bpple", "apple", "banan", "kiww"};
        solution(strs, targets); //true, ture, false, false, true
    }
}
