package string;

public class Q9 {
    public static void main(String[] args) {
        int n = 125;
        Q9 q = new Q9();
        int result = q.solution(n);
        System.out.println("result:"+result);
    }

    public int solution(int n){
        String str = Integer.toString(n, 3);
        String revered = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(revered, 3);
    }
}
