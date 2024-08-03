package programmers.sorting;

import java.util.Arrays;

public class Q27 {
    public static void main(String[] args) {
        // ["sun","bed","car"]      1   ->  ["car","bed","sun"]
        // ["abce","abcd","cdx"]    2   ->  ["abcd","abce","cdx"]
        String[] strings = {"abce","abcd","cdx"};
        int n = 2;
        Q27 q = new Q27();
        String[] result = q.solution(strings, n);
        System.out.println("result = " + Arrays.toString(result));

        Q27Solution solution = new Q27Solution();
        String[] result2 = solution.solution(strings, n);
        System.out.println("result2 = " + Arrays.toString(result2));
    }

    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted((s1, s2) -> {
                    if (s1.charAt(n) != s2.charAt(n)) {
                        return s1.charAt(n) - s2.charAt(n);
                    }
                    return s1.compareTo(s2);
                })
                .toArray(String[]::new);
    }
}
