class Solution {
    public int longestSubarray(int[] nums) {

        // The bitwise AND of multiple numbers is always ≤ the smallest number in that group.
        // Therefore the maximum possible AND of any subarray must be the largest single element in nums.
        // A subarray achieves this max AND only if all elements in it equal that maximum value.
         int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int count = 0, longest = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
                longest = Math.max(longest, count);
            } else {
                count = 0;
            }
        }

        return longest;
    }
}