class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMost(nums,k)-subarraysWithAtMost(nums,k-1);
    }

    public int subarraysWithAtMost(int[] nums, int k){
        int ans = 0 ;

        Map<Integer,Integer> numCount= new HashMap<>();
        int left =0;    
        int len = nums.length;
        for(int right =0;right<len;right++){
            int num = nums[right];
            numCount.put(num,numCount.getOrDefault(num,0)+1);

            while(numCount.size()>k){
                int leftNum = nums[left];
                numCount.put(leftNum,numCount.get(leftNum)-1);
                
                if(numCount.get(leftNum)==0){
                    numCount.remove(leftNum);
                }
                left++;
            }

            ans+= right-left+1;
            
        }
        return ans;
        
    }
}