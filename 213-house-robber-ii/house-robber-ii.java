class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n==0)return 0;
        if(n==1) return nums[0]; 
        // exclude the last one
        int firstHouse = getMoney(nums,0,n-2);
        int lastHouse = getMoney(nums,1,n-1);

        return Math.max(firstHouse,lastHouse);
    }

    public int getMoney(int[] nums,int start,int end){
        if(start>end) return 0;
        if(start==end)return nums[start];

        int[] dp = new int[nums.length];

        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);

        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[end];       
    }
}