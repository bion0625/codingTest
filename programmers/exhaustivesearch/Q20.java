package programmers.exhaustivesearch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q20 {
    public static void main(String[] args) {
        // 100-200*300-500+20   ->  60420
        // 50*6-3*2             ->  300
        String expression = "100-200*300-500+20";

        Q20 q = new Q20();
        int result = q.solution(expression);
        System.out.println("result = " + result);
        Q20Solution solution = new Q20Solution();
        long result2 = solution.solution(expression);
        System.out.println("result2 = " + result2);
    }

    public int solution (String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        // 1: + > - > *
        String[][] culss = {
                {"+","-","*"},
                {"+","*","-"},
                {"-","+","*"},
                {"-","*","+"},
                {"*","+","-"},
                {"*","-","+"},
        };
        int result = 0;
        for (String[] culs : culss) {
            List<String> tempTokens = new ArrayList<>(tokens);
            for (String cul : culs) {
                while (tempTokens.contains(cul)) {
                    int index = tempTokens.indexOf(cul);

                    int plus = Integer.parseInt(tempTokens.get(index - 1)) + Integer.parseInt(tempTokens.get(index + 1));
                    int minus = Integer.parseInt(tempTokens.get(index - 1)) - Integer.parseInt(tempTokens.get(index + 1));
                    int multiple = Integer.parseInt(tempTokens.get(index - 1)) * Integer.parseInt(tempTokens.get(index + 1));
                    int temp = cul.equals("+") ? plus : cul.equals("-") ? minus : multiple;

                    tempTokens.remove(index+1);
                    tempTokens.remove(index);
                    tempTokens.remove(index-1);
                    tempTokens.add(index-1, String.valueOf(temp));
                }
            }
            int tempResult = Integer.parseInt(tempTokens.get(0));
            if (tempResult < 0) tempResult *= -1;
            if (tempResult > result) result = tempResult;
        }
        return result;
    }
}
