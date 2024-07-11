package ch07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q09 {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -5};

        Q09 q = new Q09();
        List<List<Integer>> results = q.threeSum2(nums);
        System.out.println(results);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // 브루트 포스 n^3 반복
        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 값이 두 번 나올 수 있다.
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 중복된 값 건너뛰기, 사유동일
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    // 중복된 값 건너뛰기, 사유동일
                    if (k > j + 1 && nums[k] == nums[k-1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // 간격을 좁혀가며 sum 계산
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 합이 0보다 작다면 왼쪽 포인터 이동
                if (sum < 0) left++;
                // 합이 0보다 크다면 오른쪽 포인터 이동
                else if (sum > 0) right--;
                else {
                    // 합이 0인 경우이므로 정답 처리
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 두 번 나올 수 있다.
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;

                    // 정답이 나왔으므로 투 포인터 모두 한 칸씩 이동
                    // 합이 0인 상황이므로 양쪽 모두 이동해야 한다.
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
