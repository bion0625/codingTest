package programmers.string;

public class Q14 {
    public static void main(String[] args) {
        Q14 q = new Q14();

        String newId = "...!@BaT#*..y.ab cdefghijklm";
        String result = q.solution(newId);
        System.out.println(newId + " => " + result);
        newId = "z-+.^.";
        result = q.solution(newId);
        System.out.println(newId + " => " + result);
        newId = "=.=";
        result = q.solution(newId);
        System.out.println(newId + " => " + result);
        newId = "123_.def";
        result = q.solution(newId);
        System.out.println(newId + " => " + result);
        newId = "abcdefghijklmn.p";
        result = q.solution(newId);
        System.out.println(newId + " => " + result);
    }

    public String solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]","");
        newId = newId.replaceAll("\\.+", ".");
        newId = newId.replaceAll("^\\.+|\\.+$", "");
        if (newId.isEmpty()) newId = "a";
        if (newId.length() > 15) {
            newId = newId.substring(0,15);
            newId = newId.replaceAll("\\.+$", "");
        }
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }
        return newId;
//        newId = newId.toLowerCase();
//        for (char c : newId.toCharArray()) {
//            if (!(c >= 'a' && c <= 'z')
//                    && !(c >= '0' && c <= '9')
//                    && c != '-' && c != '_' && c != '.')
//                newId = newId.replace(String.valueOf(c), "");
//        }
//        char last = ' ';
//        for (char c : newId.toCharArray()) {
//            if (c == '.' && last == '.') {
//                newId = newId.replace("..", ".");
//            }
//            last = c;
//        }
//        if (newId.startsWith(".")) newId = newId.substring(1);
//        if (newId.endsWith(".")) newId = newId.substring(0, newId.length()-1);
//        if (newId.length() == 0) newId = "a";
//        if (newId.length() >= 16) newId = newId.substring(0, 15);
//        if (newId.endsWith(".")) newId = newId.substring(0, newId.length()-1);
//        StringBuilder new_idBuilder = new StringBuilder(newId);
//        while (new_idBuilder.length() <= 2) {
//            new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
//        }
//        newId = new_idBuilder.toString();
    }
}
