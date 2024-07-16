package doit.ch03;

public class Q003 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};

        Q003 q = new Q003();
        System.out.println("result => " + q.solution(nums, 1, 3));
        System.out.println("result => " + q.solution(nums, 2, 4));
        System.out.println("result => " + q.solution(nums, 5, 5));
    }

    int[] sum = null;
    public int solution(int[] nums, int start, int end) {
        if (sum == null) {
            sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) sum[i] = nums[i];
                else sum[i] = sum[i-1] + nums[i];
            }
        }
        return sum[end - 1] - (start - 2 >= 0 ? sum[start - 2] : 0);
    }
}
