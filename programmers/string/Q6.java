package programmers.string;

public class Q6 {
    public static void main(String[] args) {
        String s = "AB";
        int n = 1;

        Q6 q6 = new Q6();
        String result = q6.solution(s, n);
        System.out.println(result);
    }

    private String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(push(c, n));
        }
        return builder.toString();
    }

    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) return c;
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }
}
