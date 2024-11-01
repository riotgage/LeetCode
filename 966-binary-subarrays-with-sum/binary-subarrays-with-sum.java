class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefix_sum = 0;
        int len = nums.length;
        int count =0;
        
        Map<Integer,Integer> m = new HashMap<>();
        
        m.put(0,1);
        for(int i=0;i<len;i++){

            prefix_sum +=nums[i];

            if(m.containsKey(prefix_sum-goal)){
                count+= m.get(prefix_sum-goal);
            }

            m.put(prefix_sum, m.getOrDefault(prefix_sum, 0) + 1);

        }

        return count; 
    }
}