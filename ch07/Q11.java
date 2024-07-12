package ch07;

public class Q11 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};

        Q11 q = new Q11();
        int[] results = q.productExceptSelf(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
        for (int num : results) {
            System.out.print(num + ",");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        // 왼쪽 곱셈
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            // 왼쪽 곱셈 결과
            p *= nums[i];
        }
        // 오른쪽 곱셈, 왼쪽 곱셈 결과에서 차례대로 곱하기
        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            // 오른쪽 곱셈 결과
            p *= nums[i];
        }
        return result;
    }

    public int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        int p = 1;
        int k = 1;

//        result[0] = nums[1] * nums[2] * nums[3]                                ;
//        result[1] = nums[2] * nums[3]                                 * nums[0];
//        result[2] = nums[3]                                 * nums[1] * nums[0];
//        result[3] =                                 nums[2] * nums[1] * nums[0];

        for (int i = 0; i < nums.length * 2; i++) {
            if (i >= nums.length) {
                result[(2 * nums.length - 1) - i] *= k;
                k *= nums[(2 * nums.length - 1) - i];
            }else {
                result[i] = p;
                p *= nums[i];
            }
        }

        return result;
    }

}
