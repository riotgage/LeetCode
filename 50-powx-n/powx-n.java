class Solution {
    public double myPow(double x, int n) {
        
        if(n==0)return 1;

         if (n == Integer.MIN_VALUE) {
            double halfPow = myPow(x, Integer.MIN_VALUE / 2);
            return halfPow * halfPow;
        }

        
        if(n<0){
            x=1/x;
            n=-n;
        }
        double half = myPow(x,n/2);
        
        
        if(n%2==1){
            return x * half * half;
        }
        return half*half;
    }
}