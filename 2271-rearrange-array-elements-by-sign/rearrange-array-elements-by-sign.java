class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ansArr = new int[nums.length];
        int len=nums.length;

        int pos=0;
        int neg=1;

        for(int i=0;i<len;i++){
            int num = nums[i];

            if(num>0){
                ansArr[pos]=nums[i];
                pos+=2;
            }else{
                ansArr[neg]=nums[i];
                neg+=2;
            }
        }
        return ansArr;
    }
}