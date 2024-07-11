package ch07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q10 {
    public static void main(String[] arge) {
        int[] nums = new int[]{1, 3, 4, 2};
        Q10 q = new Q10();
        int result = q.arrayPairSum2(nums);
        System.out.println("result => " + result);
    }

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);

        // 앞에서부터 오름차순으로 반복
        for (int n : nums) {
            pair.add(n);
            // 페어 변수에 값이 2개 채워지면 min()을 합산하고 변수 초기화
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }

        return sum;
    }

    public int arrayPairSum2(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        // 앞에서부터 오름차순으로 인덱스 반복
        for (int i = 0; i < nums.length; i++) {
            // 짝수 번째일 때 값의 합 계산
            if (i%2==0) sum+=nums[i];
        }

        return sum;
    }
}
