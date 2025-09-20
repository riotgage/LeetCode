class Solution {
    public void sortColors(int[] nums) {
       int redPointer = 0;
       int whitePointer = 0;
       int bluePointer = nums.length-1;

       while(whitePointer<=bluePointer){
            int flagColor=nums[whitePointer];

            if(flagColor==0){
                swap(nums,redPointer++,whitePointer++);
            }else if(flagColor==1){
                whitePointer++;
            }else{
                swap(nums,whitePointer,bluePointer--);
            }
       }
    }

    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}