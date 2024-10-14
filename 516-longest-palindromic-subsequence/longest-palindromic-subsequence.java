class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        return getLcsLength(s,new StringBuilder(s).reverse().toString(),n,n);
    }

    public static int getLcsLength(String s,String t,int n,int m){
        if(n==0 || m==0)return 0;

		int[][] dp =new int[n+1][m+1];

		Arrays.fill(dp[0],0);

		for(int i=0;i<=n;i++){
			dp[i][0]=0;
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j]=1+dp[i-1][j-1];
				}else{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}

		return dp[n][m];
    }
}