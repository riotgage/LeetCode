class Solution {

    int ways = 0;
    public int climbStairs(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[0]=1;
        memo[1]=1;
        return cstairs(n,memo);
    }

    public int cstairs(int currentStair,int []memo){

        if(currentStair<2){
            return 1;
        }
        if(memo[currentStair]!= -1) return memo[currentStair];

        

        memo[currentStair] = cstairs(currentStair-1,memo) +cstairs(currentStair-2,memo);
        return memo[currentStair];
    }
}