package java07practice;

import java.util.*;

//그래프 이용
//메일 주소들은 각각의 노드
public class Practice3 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        HashMap<String, HashSet<String>> graph = new HashMap<>(); //이메일 노드 , 인접 노드
        HashMap<String, String> name = new HashMap<>(); //각 노드 , 실사용자 이름

        for (ArrayList<String> account : accounts) {
            String userName = account.get(0); //사용자 이름 받아서 name쪽 hashmap에 정리

            for (int i = 1; i < account.size(); i++) {//그래프에 노드추가
                if (!graph.containsKey(account.get(i))) { //해당하는 이메일 주소 존재하는가 ?
                    graph.put(account.get(i), new HashSet<>()); //없으면 추가
                }
                name.put(account.get(i), userName);

                if (i == 1) {
                    continue;
                }

                //노드에 대해 연결
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        //순회하며 정리작업
        HashSet<String> visited = new HashSet<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String email : name.keySet()) { //이메일 주소 가져옴
            ArrayList<String> list = new ArrayList<>(); //해당 위치에서 연결된 애들 정리할 변수

            if (visited.add(email)) { //현재 이메일 넣었는데 넣어지면 방문 안한 이메일
                dfs(graph, email, visited, list);
                Collections.sort(list); //정렬된 이메일 리스트
                list.add(0, name.get(email)); //누구의 이메일주소인지 알려주려고
                result.add(list);
            }
        }

        return result;
    }

    public static void dfs(HashMap<String, HashSet<String>> graph, String email, HashSet<String> visited, ArrayList<String> list) {
        list.add(email);
        for (String next : graph.get(email)) { //인접한 애들 search
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }

    public static void main(String[] args) {
        //TestCode
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts = solution(accounts);

        for (ArrayList<String> item : accounts) {
            System.out.println(item);
        }
    }
}
