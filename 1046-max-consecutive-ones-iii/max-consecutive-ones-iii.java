class Solution {
    public int longestOnes(int[] nums, int k) {
        int start =0, end=0;
        int ans = 0;
        int len = nums.length;
        int zeros =0;
        while(end<len){
            if(nums[end] == 0)zeros++;

            while(zeros>k){
                if(nums[start]==0)zeros--;
                start++;
            }

            ans = Math.max(ans,end-start+1);
            end++;
        }
        return ans;
    }
}