class Solution {
    public int minCut(String s) {
        
        int n = s.length();
        int dp[][] = new int[n][n];

        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return solve(s,0,s.length()-1,dp);
    }

    public int solve(String s,int i,int j,int dp[][]){
        if(i==j || isPalindrome(s,i,j)){
            return 0;
        }

        if(dp[i][j]!=-1)return dp[i][j];

        int cuts = Integer.MAX_VALUE;

        for(int start=i;start<j;start++){

            if(isPalindrome(s,i,start)){
                int c = 1+solve(s,start+1,j,dp);
                cuts = Math.min(cuts,c);
            }
        }
        dp[i][j]=cuts;
        return dp[i][j];
    }

    public boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}