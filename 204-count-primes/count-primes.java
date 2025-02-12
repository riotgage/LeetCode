class Solution {
    public int countPrimes(int n) {
        
        boolean [] isPrime = new boolean[n];
        
        Arrays.fill(isPrime, true);  // Assume all numbers are prime
        if(n<2)return 0;
        isPrime[0] = isPrime[1] = false;
        int count=0;
        for(int i=2;i*i<n;i++){
            
            if(isPrime[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(isPrime[i]){
                count++;
            }
        }

        return count;
    }
}