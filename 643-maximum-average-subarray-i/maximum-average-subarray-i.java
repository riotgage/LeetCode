class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0,right=0;
        int size=nums.length;
        double maxAverage=Double.NEGATIVE_INFINITY;
        int sum=0;
        while(right<size){
            sum+=nums[right];
            if(right-left+1==k){
                double average=(double)sum/k;
                maxAverage=Math.max(average,maxAverage);
                sum-=nums[left++];
            }
            right++;
        }
        return maxAverage;
    }
}