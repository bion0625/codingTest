package programmers.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q16 {
    public static void main(String[] args) {
        // 1 -> [1,3]
        // 2 -> [1,2],  [1,3],[2,3]
        // 3 -> [1,3],  [1,2],[3,2],    [1,3],[2,1],[2,3],[1,3]
        // 4 -> [1,2],  [1,3],[2,3],    [1,2],[3,1],[3,2],[1,2],    [1,3],[2,3],[2,1],[3,1],[2,3],[1,2],[1,3],[2,3]

        Q16 q = new Q16();
        List<int[]> result = q.solution(4);
        int cnt = 1;
        for (int[] ints : result) {
            boolean flag = false;
            for (int i = 1; i < cnt; i++) {
                if (Math.pow(2, i) == cnt) {
                    flag = true;
                    break;
                }
            }
            if (flag) System.out.println();
            System.out.print(Arrays.toString(ints));
            cnt++;
        }
    }

    public List<int[]> solution(int n) {
        return moveHanoi(n, 1, 3, new ArrayList<>());
    }

    public List<int[]> moveHanoi(int n, int from, int to, List<int[]> result) {
        // 남는 원판 계산 (from이 1, to가 2면 empty가 3: n차로 소급)
        int empty = 6 - from - to;
        // 점화식 종료 조건이자, 1개의 원판이면 무조건 돌아오는 경우의 수
        if (n == 1) {
            result.add(new int[]{from, to});
            return result;
        }
        // n-1개의 원판을 (n이 2면 1개로 소급) 남는 원판(empty)으로 옮기기
        moveHanoi(n - 1, from, empty, result);
        // n번째 가장 큰 원판을 목적 원판으로 옮기기
        result.add(new int[]{from, to});
        // n-1개의 원판을 남는 원판(empty)에서 다시 목적 원판으로 옮기기
        moveHanoi(n - 1, empty, to, result);
        return result;
    }
}
