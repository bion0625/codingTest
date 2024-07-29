package programmers.exhaustivesearch;

import java.util.*;
import java.util.stream.IntStream;

public class Q18 {
    public static void main(String[] args) {
        // 1:   1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,...
        // 2:   2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,...
        // 3:   3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,...

        // [1,2,3,4,5] -> [1]
        // [1,3,2,4,2] -> [1,2,3]

        Q18 q = new Q18();
        int[] answers = {1,3,2,4,2};
        int[] result = q.solution2(answers);
        System.out.println(Arrays.toString(result));

        Q18Solution solution = new Q18Solution();
        int[] result2 = solution.solution(answers);
        System.out.println(Arrays.toString(result2));
    }

    public int[] solution(int[] answers) {
        int one = 0;
        int two = 0;
        int three = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == i%5+1) {
                one++;
            }
            if (answers[i] == (i%2 == 0 ? 2 : i%8 == 1 || i%8 == 3 ? i%8 : i%8 == 5 ? 4 : 5)) {
                two++;
            }
            if (answers[i] == (i%10 == 0 || i%10 == 1 ? 3 : i%10 == 2 || i%10 == 3 ? 1 :  i%10 == 4 || i%10 == 5 ? 2 : i%10 == 6 || i%10 == 7 ? 4: 5)) {
                three++;
            }
        }

        int max = Math.max(Math.max(one, two), three);
        if (one == max) {
            if (two == max) {
                if (three == max) return new int[]{1,2,3};
                else return new int[]{1,2};
            } else return new int[]{1};
        } else if (two == max) {
            if (three == max) return new int[]{2,3};
            else return new int[]{2};
        } else return new int[]{3};
    }

    public int[] solution2(int[] answers) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        for (int i = 0; i < answers.length; i++) {
            for (Integer person : map.keySet()) {
                if (answers[i] == getPicked(person, i)) map.put(person, map.get(person)+1);
            }
        }

        for (Integer person : map.keySet()) {
            if(map.get(person) > max) max = map.get(person);
        }

        final int corMax = max;

        return IntStream.range(1,4)
                .filter(i -> map.get(i) == corMax)
                .toArray();
    }

    public int getPicked(int person, int index) {
        // 1:   1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,...
        // 2:   2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,...
        // 3:   3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,...
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{1,2,3,4,5});
        map.put(2, new int[]{2,1,2,3,2,4,2,5});
        map.put(3, new int[]{3,3,1,1,2,2,4,4,5,5});
        int[] list = map.get(person);
        return list[index%list.length];
    }
}
