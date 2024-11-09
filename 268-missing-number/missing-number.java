class Solution {
    public int missingNumber(int[] nums) {
        
        // Using XOR
        // int num=0;
        // int num2=0;
        // for(int i=1;i<nums.length+1;i++){
        //     num^=i;
        // }
        // for(int i:nums){
        //     num2^=i;
        // }

        // return num^num2;

        // Using Cycle Sort

        int i =0;

        while(i<nums.length){

            int index = nums[i];

            if(index <nums.length && index!=i){
                int t = nums[index];
                nums[index]= nums[i];
                nums[i]=t;
            }else{
                i++;
            }
        }

        for( i=0;i<nums.length;i++){
            if(nums[i]!=i)return i;
        }
        return i;
    }
}