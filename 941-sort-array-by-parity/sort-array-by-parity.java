class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenPointer = 0;
        int oddPointer = nums.length-1;
        int len = nums.length;
        while(evenPointer<oddPointer){
            while( evenPointer<len && nums[evenPointer]%2==0){
                evenPointer++;
            }
            while( oddPointer >= 0 && nums[oddPointer]%2==1){
                oddPointer--;
            }
            
            if(evenPointer > oddPointer) break;
            System.out.println(evenPointer+" "+oddPointer);
            // swap even and odd
            int t = nums[evenPointer];
            nums[evenPointer] = nums[oddPointer];
            nums[oddPointer] = t;
        }
        return nums;
    }
}