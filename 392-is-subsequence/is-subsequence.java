class Solution {
    public boolean isSubsequence(String s, String t) {
        // int sPointer = 0;
        // int tPointer = 0;

        // while(sPointer<s.length() && tPointer<t.length()){
        //     if(s.charAt(sPointer)==t.charAt(tPointer)){
        //         sPointer++;
        //     }
        //     tPointer++;
        // }

        // if(sPointer==s.length())return true;

        // return false;
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

        return dp[n][m] == n;
    }
}