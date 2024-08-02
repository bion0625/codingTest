package programmers.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q24 {
    public static void main(String[] args) {
        // [2,1,3,4,1]      ->      [2,3,4,5,6,7]
        // [5,0,2,7]        ->      [2,5,7,9,12]
        int[] numbers = {2,1,3,4,1};

        Q24 q = new Q24();
        int[] result = q.solution(numbers);
        System.out.println("result = " + Arrays.toString(result));

        Q24Solution solution = new Q24Solution();
        int[] result2 = solution.solution(numbers);
        System.out.println("result2 = " + Arrays.toString(result2));
    }

    public int[] solution(int[] numbers) {
        Set<Integer> resultSet = new HashSet<>();

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                resultSet.add(numbers[i] + numbers[j]);
            }
        }

        int[] results = new int[resultSet.size()];
        int cnt = 0;
        for (Integer result : resultSet) {
            results[cnt++] = result;
        }

        return results;
    }
}
