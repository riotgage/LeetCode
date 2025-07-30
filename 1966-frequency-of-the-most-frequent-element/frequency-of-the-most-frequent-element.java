class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); 
        int left = 0;
        long total = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {

            // tracks sum of our current window
            total += nums[right];

            // total + k: we can make k increments in our window so sum can go up by + k

            // nums[right] * (right - left + 1) Every num in window becomes nums[right]. 
            // This mult will be the sum

            // if mult sum is smaller than or equal to total+K. This implies that we have some k to spare.so we can expand to right
            // if mult sum is greater than total+k implies that we have extra nums in window we can shrink it by moving left. 
            while ((long) nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}