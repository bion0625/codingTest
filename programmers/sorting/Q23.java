package programmers.sorting;

import java.util.Arrays;

public class Q23 {
    public static void main(String[] args) {
        // [1,5,2,6,3,7,4]
        // [2,5,3],[4,4,1],[1,7,3]
        // [5,6,3]
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };

        Q23 q = new Q23();
        int[] result = q.solution(array, commands);
        System.out.println("result = " + Arrays.toString(result));

        Q23Solution solution = new Q23Solution();
        int[] result2 = solution.solution(array, commands);
        System.out.println("result2 = " + Arrays.toString(result2));
    }

    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(command -> {
                    int[] result = new int[command[1] - command[0] + 1];
                    for (int i = command[0]; i <= command[1]; i++) {
                        result[i - command[0]] = array[i - 1];
                    }
                    Arrays.sort(result);
                    return result[command[2] - 1];
                }).toArray();
    }
}
