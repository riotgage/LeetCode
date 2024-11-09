class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        int len = nums.length;

        while(i<len){
            int expectedIndex = nums[i]-1;

            if( nums[expectedIndex] != nums[i]){
                int t = nums[i];
                nums[i]=nums[expectedIndex];
                nums[expectedIndex]= t;
            }else{
                i++;
            }
        }

        for(i=0;i<len;i++){
            if(nums[i]!=i+1 && nums[i]==nums[nums[i]-1])return nums[i];
        }
        return -1;
        
    }
}