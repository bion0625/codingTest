package programmers.self;

import java.util.Arrays;

public class Q15 {
    public static void main(String[] args) {
        // 4,9
//        int[][] s = {
//                {1,1,0,0},
//                {1,0,0,0},
//                {1,0,0,1},
//                {1,1,1,1}
//        };

        // 10,15
        int[][] s = {
                {1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1},
        };

        Q15 q = new Q15();
        System.out.println(Arrays.toString(q.solution(s)));
        System.out.println(Arrays.toString(q.solution2(s)));
    }

    public int[] solution(int[][] s) {
        return allSum(s, s.length/2, 0, 0);
    }

    public int[] allSum(int[][] s, int size, int yStart, int xStart) {
        int[] result = {0,0};

        int[] xs = {xStart, xStart+size};
        int[] ys = {yStart, yStart+size};

        for (int y : ys) {
            for (int x : xs) {
                int[] tempSum = sum(y, x, s, size);
                result[0] += tempSum[0];
                result[1] += tempSum[1];
            }
        }

        return result;
    }

    public int[] sum(int y, int x, int[][] s, int size) {
        int[] result = {0,0};
        int curY = y;
        while (curY < y+size) {
            int curX = x;
            while (curX < x+size) {
                if (s[curY][curX] == 0) result[0]++;
                if (s[curY][curX] == 1) result[1]++;
                curX++;
            }
            curY++;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == size * size) result[i] = 1;
        }
        if (!((result[0] == 1 && result[1] == 0) || (result[1] == 1 && result[0] == 0)) && size > 2){
            int[] tempSum = allSum(s, size / 2, y, x);
            result[0] = tempSum[0];
            result[1] = tempSum[1];
        }
        return result;
    }

    /**
     * Count
     * */
    public int[] solution2(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    private static class Count{
        public final int zero;
        public final int one;

        private Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }
}
