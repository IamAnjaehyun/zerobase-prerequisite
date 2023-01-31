package java07practice;

import java.util.ArrayList;
import java.util.HashMap;

//패턴을 트라이로 구성
class Node {
    HashMap<Character, java07practice.Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie2 {
    java07practice.Node root;
    ArrayList<Character> capitals;


    public Trie2() {
        this.root = new java07practice.Node();
        this.capitals = new ArrayList<>();
    }

    public void insert(String str) {
        java07practice.Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); //문자열 받아서 끊어서

            if (c < 'a') {
                capitals.add(c);
            }

            cur.child.putIfAbsent(c, new java07practice.Node()); //키 밸류 쌍으로 넣어줄건데 c로 시작하는게 없으면 추가하고 없으면 넘어감
            cur = cur.child.get(c); //이동

            if (i == str.length() - 1) {
                cur.isTerminal = true; //끝에 도달하면 terminal true로 넣어줌
                return;
            }
        }
    }

    public boolean search(String str) {
        java07practice.Node cur = this.root;
        ArrayList<Character> cap = new ArrayList<>(capitals);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cap.remove(new Character(c));
                cur = cur.child.get(c);
            } else {
                if (c < 'a') {
                    return false;
                } else {
                    continue;
                }
            }
            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return cap.size() == 0;
    }
}


public class Practice10 {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {
        Trie2 trie = new Trie2();
        trie.insert(pattern);

        ArrayList<Boolean> result = new ArrayList<>();

        for(String query : queries){
            result.add(trie.search(query));
        }

        return result;
    }

    public static void main(String[] args) {
        //TestCode
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));

    }
}
