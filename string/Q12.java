package string;

public class Q12 {
    public static void main(String[] args) {
        Q12 q = new Q12();
        String s = "one4seveneight";
        System.out.println(s + " => " + q.solution("one4seveneight"));
        s = "23four5six7";
        System.out.println(s + " => " + q.solution("23four5six7"));
        s = "2three45six7";
        System.out.println(s + " => " + q.solution("2three45six7"));
        s = "123";
        System.out.println(s + " => " + q.solution("123"));
    }

    private static final String[] words = {
            "zero","one","two","three","four",
            "five","six","seven","eight","nine"
    };
    public int solution(String s) {
        for (int i = 0; i < words.length; i++) {
            s = s.replaceAll(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
