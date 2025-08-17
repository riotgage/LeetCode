class Solution {
    public void sortColors(int[] nums) {
       int onePointer=0;
       int zeroPointer=0;
       int twoPointer=nums.length-1;

       while(onePointer<=twoPointer){
            int num = nums[onePointer];

            // swap with zero pointer and move ahead
            if(num==0){
                swap(nums,zeroPointer++,onePointer++);
            }else if(num==1){
                onePointer++;
            }else{
                swap(nums,onePointer,twoPointer--);
            }
       }
       
    }

    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}