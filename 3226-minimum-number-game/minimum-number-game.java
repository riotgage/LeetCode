class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] ans=new int[nums.length];
        for(int i=1;i<nums.length;i=i+2){
            ans[i]=nums[i-1];
            ans[i-1]=nums[i];
        }
        return ans;
    }
}