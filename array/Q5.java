package array;

public class Q5 {
    public static void main(String[] args) {
        Q5 q5 = new Q5();
        int[] result = q5.solution(12345);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i == result.length-1 ? "" : ","));
        }
    }

    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        return result;
    }
}
