class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] prefixMult = new int[len];
        int [] suffixMult = new int[len];
        int [] ans = new int[len];
        prefixMult[0]=1;
        suffixMult[len-1]= 1;

        for(int i=1; i<len;i++){
            prefixMult[i]=prefixMult[i-1]*nums[i-1];
            suffixMult[len-i-1]=suffixMult[len-i]*nums[len-i];
        }

        for(int i=0;i<len;i++){
            ans[i]=prefixMult[i]*suffixMult[i];
        }

        return ans;
    }
}