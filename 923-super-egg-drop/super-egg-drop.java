class Solution {
    public int superEggDrop(int n, int k) {
        
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(n,k,dp);
    }

    public int solve(int e,int f,int[][] dp){
        
        if(e==1 || f==0 || f==1 ){
            return f;
        }

        if(dp[e][f]!=-1){
            return dp[e][f];
        }

        int mn = Integer.MAX_VALUE;

        // for(int k=1;k<=f;k++){
        //     int temp1,temp2;

        //     if(dp[e][f-k]!=-1) temp1 = dp[e][f-k];
        //     else {
        //         temp1 = solve(e,f-k,dp);
        //         dp[e][f-k] = temp1;
        //     }
        //     if(dp[e-1][k-1]!=-1) temp2 = dp[e-1][k-1];
        //     else{
        //         temp2 = solve(e-1,k-1,dp);
        //         dp[e-1][k-1] = temp2;
        //     }
            
        //     int temp = 1+ Math.max(temp1,temp2);

        //     mn = Math.min(temp,mn);
        // }

        int low = 1, high = f;

        while (low <= high) {

            int mid = (low + high) / 2;
            int eggBreaks = solve(e - 1, mid - 1, dp);  // Egg breaks
            int eggDoesntBreak = solve(e, f - mid, dp); // Egg doesn't break

            int worstCaseAttempts = 1 + Math.max(eggBreaks, eggDoesntBreak);

            // Minimize the maximum number of attempts
            mn = Math.min(mn, worstCaseAttempts);

            // Adjust search based on which side has the larger attempts
            if (eggBreaks > eggDoesntBreak) {
                high = mid - 1;  // Explore lower floors
            } else {
                low = mid + 1;   // Explore higher floors
            }
        }

        dp[e][f] = mn;

        return dp[e][f];
    }
}