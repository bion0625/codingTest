package doit.ch03;

public class Q001 {
    public static void main(String[] args) {
        Q001 q = new Q001();

        q.setResult(1,1);
        q.setResult(5,54321);
        q.setResult(25,7000000);
        q.setResult(11,10987654321L);
    }

    private void setResult(long first, long second) {
        System.out.printf("first => %d\tsecond => %d\tresult => %d\n", first, second, solution(first, second));
    }

    public long solution(long first, long second) {
        long result = 0 ;
        char[] arr = String.valueOf(second).toCharArray();
        for (char c : arr) {
            result += Integer.parseInt(String.valueOf(c));
        }
        return result;
    }
}
