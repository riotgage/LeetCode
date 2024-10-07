class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num: nums){
            sum+=num;
        }

        if(sum%2==1)return false;

        return isSubSetSum(nums,nums.length,sum/2);
    }

    public boolean isSubSetSum(int[] nums,int n,int target){
        Boolean dp[][] = new Boolean[n+1][target+1];

        for(int j=0;j<=target;j++){
            dp[0][j]=false;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){

                if(j<nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{

                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][target];


    }
}