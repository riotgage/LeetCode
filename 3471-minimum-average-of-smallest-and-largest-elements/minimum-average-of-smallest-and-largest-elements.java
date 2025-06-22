class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double minAvg = Double.MAX_VALUE;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            double avg = (nums[i++] + nums[j--]) / 2.0;
            minAvg = Math.min(minAvg, avg);
        }
        return minAvg;
        
    }
}