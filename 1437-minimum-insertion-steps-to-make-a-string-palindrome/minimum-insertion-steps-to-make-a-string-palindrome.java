class Solution {
    public int minInsertions(String s) {
        // Find the maximum palindrome subsequence length of s
        // no of insertions = no of deletions = s length - lps length
        
        String t =new StringBuilder(s).reverse().toString(); 
        int m = t.length();
        int n = s.length();
        
        int dp[] [] = new int[n+1][m+1];

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

        return n-dp[n][m];
    }
}