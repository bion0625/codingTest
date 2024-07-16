package doit.ch03;

public class Q002 {
    public static void main(String[] args) {
        Q002 q = new Q002();

        q.setResult("3","40 80 60");
        q.setResult("3","10 20 30");
        q.setResult("4","1 100 100 100");
        q.setResult("5","1 2 4 8 16");
        q.setResult("2","3 10");
    }

    private void setResult(String first, String second) {
        System.out.printf("first => %s\tsecond => %s\tresult => %s\n", first, second, solution(first, second));
    }

    public double solution(String first, String second) {
        double cnt = Double.parseDouble(first);
        String[] split = second.split(" ");
        int[] scores = new int[split.length];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            scores[i] = Integer.parseInt(split[i]);
            max = Math.max(max, scores[i]);
            sum += scores[i];
        }
        return sum * 100.0 / max / cnt;
    }
}
