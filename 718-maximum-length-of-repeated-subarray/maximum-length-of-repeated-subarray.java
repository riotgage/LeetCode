class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        return solve(nums1,nums2,n,m);
    }

    public int solve(int[] nums1, int[] nums2,int n,int m){
        if(n==0 || m==0)return 0;

        int dp[][] = new int[n+1][m+1];

        Arrays.fill(dp[0],0);

        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        int ans =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }

        return ans;
    }
}