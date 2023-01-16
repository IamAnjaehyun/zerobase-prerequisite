package java06trie;
//Practice1
//문자열 배열 strs와 문자열 perfix가 주어졌을 때
//문자열 배열 내에 prefix로 시작하는 단어가 있는지를 확인하는 프로그램을 작성하세요.
//prefix로 시작하는 단어가 있으면 true, 없으면 false를 반환하세요.

//입출력 예시
//입력 strs : "apple","april","app","ace","bear","best"
//입력 prefix : "app"
//출력 : true

//입력 strs : "apple", "april", "app", "ace", "bear", "best"
//입력 prefix : "pre"
//출력 : flase

import java.util.HashMap;

class Node1 {
    HashMap<Character, Node1> child;
    boolean isTerminal;

    public Node1() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie1 {
    Node1 root;

    public Trie1() {
        this.root = new Node1();
    }

    public void insert(String str) {
        Node1 cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node1());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        Node1 cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }

    public void delete(String str) {
        boolean ret = this.delete(this.root, str, 0);
        if (ret) {
            System.out.println(str + " 삭제 완료 !");
        } else {
            System.out.println(str + " 단어가 없습니다 !");
        }
    }

    public boolean delete(Node1 node, String str, int idx) {
        char c = str.charAt(idx);

        if (!node.child.containsKey(c)) {
            return false;
        }

        Node1 cur = node.child.get(c);
        idx++;

        if (idx == str.length()) {
            if (!cur.isTerminal) {
                return false;
            }
            cur.isTerminal = false;
            if (cur.child.isEmpty()) {
                node.child.remove(c);
            }
        } else {
            if (!this.delete(cur, str, idx)) {
                return false;
            }
            if (!cur.isTerminal && cur.child.isEmpty()) {
                node.child.remove(c);
            }
        }
        return true;
    }
}

public class Practice1 {
    public static boolean solution(String[] strs, String prefix) {
        Trie1 trie = new Trie1();
        for (String str : strs) {
            trie.insert(str);
        }

        Node1 cur = trie.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (cur.child.get(c) == null) {
                return false;
            }
            cur = cur.child.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        //TestCode
        String[] strs = {"apple", "april", "app", "ace", "bear", "best"};
        String prefix = "app";
        System.out.println(solution(strs, prefix)); //t

        prefix = "be";
        System.out.println(solution(strs, prefix)); //t

        prefix = "pre";
        System.out.println(solution(strs, prefix)); //t

    }
}
