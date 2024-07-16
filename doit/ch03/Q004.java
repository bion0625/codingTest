package doit.ch03;

public class Q004 {
    public static void main(String[] args) {
        int[][] table = new int[][]{
                {1,2,3,4},
                {2,3,4,5},
                {3,4,5,6},
                {4,5,6,7}
        };

        Q004 q = new Q004();
//        System.out.println("result => " + q.solution2(table, 1, 1, 2, 2));
        System.out.println("result => " + q.solution2(table, 2, 2, 3, 4));
        System.out.println("result => " + q.solution2(table, 3, 4, 3, 4));
        System.out.println("result => " + q.solution2(table, 1, 1, 4, 4));
    }

    public int solution(int[][] table, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int x = x1-1;
        int y = y1-1;
        int sum = table[y][x];
        while (dx != 0 || dy != 0) {
            if (dx != 0) {
                x++;
                dx--;
            } else if (dy != 0) {
                x = x1-1;
                dx = x2 - x1;
                y++;
                dy--;
            }
            sum += table[y][x];
        }

        return sum;
    }

    public int solution2(int[][] table, int x1, int y1, int x2, int y2) {
        int [][] xSum = new int[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            int sum = 0;
            for (int j = 0; j < table[i].length; j++) {
                sum += table[i][j];
                xSum[i][j] = sum;
            }
        }
        int result = 0;
        for (int i = y1-1; i <= y2-1; i++) {
            result += xSum[i][x2-1] - (x1-2 >= 0 ? xSum[i][x1-2] : 0);
        }
        return result;
    }
}
