package programmers.self;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q17 {
    public static void main(String[] args) {
        // AEIOU / 5

        // AAAAE    ->  6
        // AAAE     ->  10
        // I        ->  1563
        // EIO      ->  1189

        String word = "AAAE";
        Q17 q = new Q17();
        int result = q.solution(word);
        System.out.println("result = " + result);

        int result1 = q.solution1(word);
        System.out.println("result1 = " + result1);

        Q17Solution solution = new Q17Solution();
        int result2 = solution.solution(word);
        System.out.println("result2 = " + result2);
        
        Q17Solution2 solution2 = new Q17Solution2();
        int result3 = solution2.solution(word);
        System.out.println("result3 = " + result3);
    }

    public int solution1(String word) {
        return generate("", new ArrayList<>()).indexOf(word);
    }

    private List<String> generate(String word, List<String> list) {
        list.add(word);
        String base = "AEIOU";
        if (word.length() == 5) return list;
        for (char c : base.toCharArray()) {
            generate(word + c, list);
        }
        return list;
    }

    public int solution(String word) {
        Set<String> set = new TreeSet<>();
        String base = "AEIOU";
        for (char c : base.toCharArray()) {
            set.add(String.valueOf(c));
        }
        for (char c : base.toCharArray()) {
            for (char c2 : base.toCharArray()) {
                set.add(String.valueOf(c) + String.valueOf(c2));
            }
        }
        for (char c : base.toCharArray()) {
            for (char c2 : base.toCharArray()) {
                for (char c3 : base.toCharArray()) {
                    set.add(String.valueOf(c) + String.valueOf(c2) + String.valueOf(c3));
                }
            }
        }
        for (char c : base.toCharArray()) {
            for (char c2 : base.toCharArray()) {
                for (char c3 : base.toCharArray()) {
                    for (char c4 : base.toCharArray()) {
                        set.add(String.valueOf(c) + String.valueOf(c2) + String.valueOf(c3) + String.valueOf(c4));
                    }
                }
            }
        }
        for (char c : base.toCharArray()) {
            for (char c2 : base.toCharArray()) {
                for (char c3 : base.toCharArray()) {
                    for (char c4 : base.toCharArray()) {
                        for (char c5 : base.toCharArray()) {
                            set.add(String.valueOf(c) + String.valueOf(c2) + String.valueOf(c3) + String.valueOf(c4) + String.valueOf(c5));
                        }
                    }
                }
            }
        }

        List<String> list = new ArrayList<>(set);

        return list.indexOf(word) + 1;
    }
}
