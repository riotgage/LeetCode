class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        int curr_max=0;

        for(int num:nums){
            curr_max +=num;

            if(max < curr_max)
                max = curr_max;

            if(curr_max<0)curr_max=0;
        }

        return max;
    }
}