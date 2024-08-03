package programmers.sorting;

public class Q26 {
    public static void main(String[] args) {
        // Zbcdefg -> gfedcbZ
        String s = "Zbcdefg";

        Q26 q = new Q26();
        String result = q.solution(s);
        System.out.println("result = " + result);

        Q26Solution solution = new Q26Solution();
        String result2 = solution.solution(s);
        System.out.println("result2 = " + result2);
    }

    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
