package programmers.string;

public class Q11 {
    public static void main(String[] args) {
        String s = "Pyy";
        Q11 q = new Q11();
        boolean result = q.solution(s);
        System.out.println("result:" + result);
    }

    public boolean solution(String s) {
        s = s.toLowerCase();
        int ps = s.length() - s.replaceAll("p","").length();
        int ys = s.length() - s.replaceAll("y","").length();
        return ps == ys;

//        int ps = 0;
//        int ys = 0;
//
//        for (char c : s.toCharArray()) {
//            switch (c) {
//                case 'p':
//                case 'P': ps++; break;
//                case 'y':
//                case 'Y': ys++; break;
//            }
//        }
//
//        return ps==ys;
    }
}
