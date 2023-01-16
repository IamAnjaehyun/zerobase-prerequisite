package java06trie;
//비선형 자료구조 - 트라이 (Trie)

import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); //문자열 받아서 끊어서

            cur.child.putIfAbsent(c, new Node()); //키 밸류 쌍으로 넣어줄건데 c로 시작하는게 없으면 추가하고 없으면 넘어감
            cur = cur.child.get(c); //이동
            if (i == str.length() - 1) {
                cur.isTerminal = true; //끝에 도달하면 terminal true로 넣어줌
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;
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
        boolean ret = this.delete(this.root, str, 0); //root 부터 문자열 찾음
        if (ret) {
            System.out.println(str + " 삭제 완료 !");
        } else {
            System.out.println(str + " 단어가 없습니다 !");
        }
    }

    public boolean delete(Node node, String str, int idx) {
        char c = str.charAt(idx);

        if (!node.child.containsKey(c)) { //없는거
            return false;
        }

        Node cur = node.child.get(c);
        idx++;

        if (idx == str.length()) { //이미 위에서 증가시켜줬음
            if (!cur.isTerminal) {
                return false;
            }

            cur.isTerminal = false; //파란색을 흰색으로 바꾸는 부분
            //더 긴 문자열 없으면 지워줌
            if(cur.child.isEmpty()){
                node.child.remove(c);
            }
        }else{ //지워야하는 문자를 찾기 전
            if(!this.delete(cur, str, idx)){
                return false;
            }
            if(!cur.isTerminal && cur.child.isEmpty()){
                node.child.remove(c);
            }
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        //TestCode
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
//        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("april"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ace"));
        System.out.println(trie.search("bear"));
        System.out.println(trie.search("best"));
        System.out.println(trie.search("abc"));

        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("april"));
        System.out.println(trie.search("appl"));
        trie.delete("apple");
    }
}
