package java08practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

class Song {
    int no;
    int play;

    public Song(int no, int play) {
        this.no = no;
        this.play = play;
    }
}

public class Practice8 {
    public static void solution(String[] genres, int[] plays) {
        Hashtable<String, ArrayList<Song>> ht = new Hashtable<>();

        for (int i = 0; i < genres.length; i++) {
            if (ht.containsKey(genres[i])) {
                ArrayList<Song> cur = ht.get(genres[i]);

                int idx = -1;
                for (int j = 0; j < cur.size(); j++) {
                    if (plays[i] > cur.get(j).play ||
                            plays[i] == cur.get(j).play && i < cur.get(j).no) {
                        idx = j;
                        break;
                    }
                }
                //해시테이블에 재생많이된순서대로 들어감
                if (idx == -1) {
                    cur.add(new Song(i, plays[i]));
                } else {
                    cur.add(idx, new Song(i, plays[i]));
                }
                ht.put(genres[i], cur);
            } else {
                Song s = new Song(i, plays[i]);
                ht.put(genres[i], new ArrayList<>(Arrays.asList(s)));
            }
        }

        Hashtable<String, Integer> htPlay = new Hashtable<>();
        for (String item : ht.keySet()) {
            int sum = 0;
            ArrayList<Song> cur = ht.get(item);
            for (int i = 0; i < cur.size(); i++) {
                sum += cur.get(i).play;
            }
            htPlay.put(item, sum);
        }


        ArrayList<Map.Entry<String, Integer>> htPlaySort = new ArrayList<>(htPlay.entrySet()); //키값 밸료 나와서 ArrayList<Map.Entry<String,Integer>>로 넘어감
        htPlaySort.sort((x1, x2) -> x2.getValue() - x1.getValue()); //큰순으로 정렬

        for (Map.Entry<String, Integer> item : htPlaySort) {
            ArrayList<Song> songs = ht.get(item.getKey());

            for (int i = 0; i < songs.size(); i++) {
                System.out.print(songs.get(i).no + " ");
                if (i == 1) {
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //TestCode
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }
}
