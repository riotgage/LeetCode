class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count =0 ;
        int[] prefixCounts = new int[nums.length + 1];
        prefixCounts[0] = 1;
        int ans =0; 

        for(int num:nums){

            if(num%2==1){
                count++;
            }

            if(count>=k){
                ans += prefixCounts[count-k];
            }
            prefixCounts[count]++;
        }

        return ans;
    }
}