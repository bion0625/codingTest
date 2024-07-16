package interview.ch07;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q08 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,0,2,1,0,1,3,2,1,2,1};

        Q08 q = new Q08();
        int result = q.trap2(nums);
        System.out.println("result => " + result);
    }

    public int solution(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == nums.length - 1) continue;
            result += getWater(i, nums);
        }
        return result;
    }

    private int getWater(int i, int[] nums) {
        int left = i-1;
        int right = i+1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left >= 0) {
            maxLeft = Math.max(nums[left], maxLeft);
            left--;
        }

        while (right < nums.length) {
            maxRight = Math.max(nums[right], maxRight);
            right++;
        }

        int water = Math.min(maxLeft, maxRight) - nums[i];
        return Math.max(water, 0);
    }

    public int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        // 투 포인터가 서로 겹칠 때까지 반복
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 더 높은 쪽을 향해 투 포인터 이동
            if (leftMax <= rightMax) {
                // 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left];
                left++;
            } else {
                // 오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }

    public int trap2(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // 변곡점을 만나는 경우
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 스택에서 꺼낸다
                Integer top = stack.pop();

                if (stack.isEmpty()) break;

                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() - 1;
                // 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                // 물이 쌓이는 양은 거리와 물 높이의 곱
                volume += distance * waters;
            }

            // 진행 하면서 현재 위치를 스택에 삽입
            stack.push(i);
        }
        return volume;
    }

}
