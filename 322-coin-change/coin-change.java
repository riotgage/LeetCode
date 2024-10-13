class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; 
        int dp[][] = new int [n+1][amount+1];
        
        Arrays.fill(dp[0],Integer.MAX_VALUE-1);
        
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];

                // If we include the current coin (coins[i-1]) and it's less than or equal to the amount
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        // If the value in dp[n][amount] is still set to the large value, it means it's not possible
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }

    public int minCoinsChange(int[] coins, int amount,int coinIndex,int dp[][]){

        if(amount == 0) return 0;
        if(coinIndex == 0 || amount  < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[coinIndex][amount]!=-1) return dp[coinIndex][amount];

        int include =  minCoinsChange(coins,amount-coins[coinIndex-1],coinIndex,dp);

        if(include != Integer.MAX_VALUE){
            include +=1;
        }

        int exclude = minCoinsChange(coins,amount,coinIndex-1,dp);

        dp[coinIndex][amount] = Math.min(include,exclude);

        return dp[coinIndex][amount];
    }
}