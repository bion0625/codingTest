package programmers.exhaustivesearch;

import java.util.Arrays;

public class Q19 {
    public static void main(String[] args) {
        // 10, 2 -> [4,3]
        // 8, 1 -> [3,3]
        // 24, 24 -> [8,6]
        int brown = 24;
        int yellow = 24;

        Q19 q = new Q19();
        int[] result = q.solution(brown, yellow);
        System.out.println("result = " + Arrays.toString(result));
        Q19Solution solution = new Q19Solution();
        System.out.println("result = " + Arrays.toString(solution.solution(brown, yellow)));
    }

    public int[] solution(int brown, int yellow) {
        for (int i = (int)Math.round(Math.sqrt(brown + yellow)); i >= 3; i++) {
            if ((brown + yellow) % i == 0 && i >= (brown + yellow) / i) {
                return new int[]{i, (brown + yellow) / i};
            }
        }
        return null;
    }
}
