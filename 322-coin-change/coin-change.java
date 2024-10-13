class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; 
        int dp[][] = new int [n+1][amount+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        
        int result = minCoinsChange(coins,amount,n,dp);;  

        if(result == Integer.MAX_VALUE)return -1;

        return result;
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