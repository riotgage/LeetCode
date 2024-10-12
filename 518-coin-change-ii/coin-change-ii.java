class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    // public int noOfCoins(int amount, int[] coins,int n,int dp[][]){

    //     if(amount == 0)return 1;

    //     if(n==0)return 0;

    //     if(dp[n][amount]!=-1)return dp[n][amount];
    //     if(coins[n-1]<=amount){
    //          dp[n][amount] = noOfCoins(amount-coins[n-1],coins,n,dp)+ noOfCoins(amount,coins,n-1,dp);
    //     }else{
    //         dp[n][amount] = noOfCoins(amount,coins,n-1,dp);
    //     }

    //     return dp[n][amount];
    // }
}