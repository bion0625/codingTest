package string;

public class Q10 {
    public static void main(String[] args) {
        String s = "01110";
        Q10 q = new Q10();
        int[] result = q.solution(s);
        System.out.println("------");
        System.out.print("["+result[0] + ","+result[1]+"]\n");
        System.out.println("------");
    }

    public int[] solution(String s) {
        int loop = 0;
        int removed= 0;

        while (!s.equals("1")){
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }

        return new int[] {loop, removed};
    }

    private int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c=='0') zeros++;
        }
        return zeros;
    }
}
