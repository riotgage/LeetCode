class Solution {
    
    public static  long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long odd=n/2;
        long even=(n+1)/2;

        return (int)(getPow(5,even) * getPow(4,odd) % MOD);
    }

    public static long getPow(long x, long n){

        if(n==0){
            return 1;
        }
       
        long temp = getPow(x,n/2);

        if(n%2==0){
            return (temp*temp)%MOD;
        }
        else{
            return (x*temp*temp)%MOD;
        }
    }
}