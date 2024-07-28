package programmers.self;

import java.util.ArrayList;
import java.util.List;

public class Q17Solution2 {
    private static final char[] CHARS = "AEIOU".toCharArray();
    
    private void generate(String word, List<String> words) {
        words.add(word);
        if (word.length() == 5) return;
        for (Character c : CHARS) {
            generate(word + c, words);
        }
    }

    public int solution(String word) {
        ArrayList<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
}
