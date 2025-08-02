class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len=nums.length;
        int max=0;
        for(int i=0;i<len;i++){

            if(nums[i]==1){
                int l=0;
                while(i<len && nums[i]==1){
                    l++;
                    i++;
                }

                if(l>max){
                    max=l;
                }
            }
        }
        
        return max;
    }
}