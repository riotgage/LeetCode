class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 )return 0;
        int dp[][] = new int[m][n];

        dp[0][0]=1;

        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0 && dp[0][i-1]==1)
                dp[0][i]=1;
            else dp[0][i]=0;
        }
                
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==0 && dp[i-1][0]==1)
                dp[i][0]=1;
            else dp[i][0]=0;
        }

        for(int row=1;row<m;row++){
            for(int col=1;col<n;col++){
                if(obstacleGrid[row][col]==0)
                    dp[row][col]=dp[row-1][col]+dp[row][col-1];
                else{
                    dp[row][col]=0;
                }
            }
        }

        return dp[m-1][n-1];
    }
}