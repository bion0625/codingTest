package ch07;

import java.util.HashMap;
import java.util.Map;

public class Q07 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 6, 11, 15};
        int target = 8;

        Q07 q = new Q07();
        int[] result = q.twoSum4(numbers, target);
        q.print(numbers);
        q.print(result);

    }

    private void print(int[] numbers) {
        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i == numbers.length - 1 ? "" : ","));
        }
    }

    public int[] twoSum(int[] nums, int target) {
        // 입력값 배열을 처음부터 순회
        for (int i = 0; i < nums.length; i++) {
            // 입력값 배열을 그다음부터 순회
            for (int j = i; j < nums.length; j++) {
                // 두 값의 합을 비교해 target과 일치하는 경우 정답으로 리턴
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        // 키와 값을 바꿔서 맵으로 저장
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        // target에서 첫 번째 수를 뺀 결과를 키로 조회하고 현재 인덱스가 아닌 경우 정답으로 리턴
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i]))
                return new int[]{i, numsMap.get(target - nums[i])};
        }

        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        // 하나의 for 반복으로 통합
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            // 정답이 아니므로 다음번 비교를 위해 인텍스를 맵에 저장
            numsMap.put(nums[i], i);
        }
        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }

    public int[] twoSum4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if (nums[left] + nums[right] < target) left++;
            // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 이동
            else if (nums[left] + nums[right] > target) right--;
            else return new int[] {left, right};
        }
        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }
}
