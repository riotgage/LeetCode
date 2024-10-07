class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
Arrays.sort(nums);
        getSubSets(nums,0,ans,new ArrayList<>());
        return ans;
    }

    public void getSubSets(int[] nums,int start,List<List<Integer>> ans,List<Integer>partAns){

            ans.add(new ArrayList<>(partAns));

        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            partAns.add(nums[i]);
            getSubSets(nums,i+1,ans,partAns);
            partAns.remove(partAns.size()-1);
        }

    }
}