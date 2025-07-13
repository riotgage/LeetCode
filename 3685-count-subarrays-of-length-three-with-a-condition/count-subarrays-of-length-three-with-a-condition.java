class Solution {
    public int countSubarrays(int[] nums) {
         int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            if (b == (a + c)*2) {
                count++;
            }
        }

        return count;
    }
}