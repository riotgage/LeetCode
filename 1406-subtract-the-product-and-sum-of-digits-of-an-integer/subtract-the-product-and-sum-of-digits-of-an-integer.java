class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int product=1;

        while(n>0){
            int digit=n%10;
            n=n/10;
            sum+=digit;
            product*=digit;
        }

        return product-sum;
    }
}