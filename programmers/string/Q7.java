package programmers.string;

public class Q7 {
    public static void main(String[] args) {
        String s = "try hello world";

        Q7 q7 = new Q7();
        String result = q7.solution(s);
        System.out.println("result: " + result);
    }

    public String solution(String s){
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                builder.append(c);
                toUpper = true;
            } else {
                if (toUpper){
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }

        return builder.toString();
    }
}
