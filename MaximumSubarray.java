import java.util.Arrays;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int[] maxsum = nums;
        for(int i=1; i<nums.length; ++i) {
            maxsum[i] = Math.max(nums[i] + maxsum[i-1], nums[i]);
        }
        return Arrays.stream(maxsum).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
