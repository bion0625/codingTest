package programmers.array;

public class Q2_1 {
    public static void main(String[] args) {
        Q2_1 q21 = new Q2_1();
        int[] result = q21.solution(4);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i == result.length - 1 ? "" : ","));
        }
    }

    public int[] solution(int n) {
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};

        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny == n || nx == n || ny == -1 || nx == -1 || triangle[ny][nx] != 0) {
                d = (d+1)%3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (ny == n || nx == n || ny == -1 || nx == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
