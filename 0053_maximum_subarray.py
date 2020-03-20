from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxsum = [nums[0]] * len(nums)
        for i in range(1, len(nums)):
            maxsum[i] = max(nums[i], nums[i] + maxsum[i-1])

        return max(maxsum)
