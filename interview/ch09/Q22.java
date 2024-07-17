package interview.ch09;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q22 {
    public static void main(String[] args) {
        // 1, 1, 4, 2, 1, 1, 0, 0
        int[] temperatures = new int[] {23, 24, 25, 21, 19, 22, 26, 23};

        Q22 q = new Q22();
        int[] result = q.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public int[] solution(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[i-1]) {
                for (int j = i-1; j >= 0 ; j--) {
                    if (result[j] == 0 && temperatures[i] > temperatures[j]) result[j] = i - j;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // 결과를 담을 정수형 배열 선언
        int[] result = new int[temperatures.length];
        // 결과 처리를 위한 스택 선언
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 현재 온도가 스택에 있는 온도보다 높다면 꺼내서 결과를 업데이트한다.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                // 결과 업데이트
                result[last] = i - last;
            }
            // 현재 인덱스를 스택에 삽입
            stack.push(i);
        }
        return result;
    }
}
