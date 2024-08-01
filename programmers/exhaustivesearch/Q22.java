package programmers.exhaustivesearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q22 {
    public static void main(String[] args) {
        // 응모자 아이디
        // frodo, fradi, crodo, abc123, frodoc
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};

        // 불량 사용자
        // fr*d*
        // abc1**

        // 경우의 수
        // 1: frodo, abc123
        // 2: fradi, abc123
//        String[] banned_id = {"fr*d*","abc1**"};

        // 불량 사용자
        // *rodo
        // *rodo
        // ******

        // 경우의 수
        // 1: frodo, crodo, abc123
        // 1: frodo, crodo, frodoc
        String[] banned_id = {"*rodo","*rodo","******"};


        Q22 q = new Q22();
        int result = q.solution(user_id, banned_id);
        System.out.println("result = " + result);

        Q22Solution solution = new Q22Solution();
        int result2 = solution.solution(user_id, banned_id);
        System.out.println("result2 = " + result2);
    }

    public int solution (String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }
        for (String id : bans[index]) {
            if (banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }
}
