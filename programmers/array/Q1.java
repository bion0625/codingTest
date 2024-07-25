package programmers.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        int[][] line = new int[5][3];
        line[0] = new int[]{2, -1, 4};
        line[1] = new int[]{-2, -1, 4};
        line[2] = new int[]{0, -1, 1};
        line[3] = new int[]{5, -8, -12};
        line[4] = new int[]{5, 8, 12};

        Q1 q1 = new Q1();
        String[] solution = q1.solution(line);
        for (String s : solution) {
            System.out.println(s);
        }
    }

    private static class Point{
        public long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        if (x % 1 != 0 || y % 1 != 0) return null;
        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x, y);
    }

    private Point getMaxmunPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        return new Point(x, y);
    }

    private String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point minimun = getMinimumPoint(points);
        Point maximun = getMaxmunPoint(points);

        int width = (int) (maximun.x - minimun.x + 1);
        int height = (int) (maximun.y - minimun.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        for (Point p : points) {
            int x = (int) (p.x - minimun.x);
            int y = (int) (maximun.y - p.y);
            arr[y][x] = '*';
        }
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }
}
