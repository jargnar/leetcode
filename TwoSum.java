/*https://leetcode.com/problems/two-sum/*/
package org.suhas.leetcode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> indices = new ArrayList<>();
        loop:
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    indices.add(i);
                    indices.add(j);
                    break loop;
                }
            }
        }
        return indices.stream().mapToInt(i -> i).toArray();
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] output = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(output));
    }
}
