package string;

public class Q13 {
    public static void main(String[] args) {
        Q13 q = new Q13();
        String s = "a234";
        boolean result = q.solution(s);
        System.out.println(s + " => " + result);
        s = "1234";
        result = q.solution(s);
        System.out.println(s + " => " + result);
    }

    public boolean solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
//        if (s.length() != 4 && s.length() != 6) return false;
//        for (char c : s.toCharArray()) {
//            if (!Character.isDigit(c)) return false;
//        }
//        return true;
    }
}
