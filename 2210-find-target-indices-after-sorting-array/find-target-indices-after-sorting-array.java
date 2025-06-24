class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> ans = new ArrayList<>();
        int smaller = 0;
        int count = 0;
        
        for(int num:nums){
            if(num<target) smaller++;
            if(num==target) count++;
        }

        for(int i=0;i<count;i++){
            ans.add(smaller+i);
        }

        return ans;
    }
}