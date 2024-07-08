class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        getSubsets(nums,ans,0,new ArrayList<Integer>());

        return ans;
    }

    public void getSubsets(int[] nums, List<List<Integer>> ans, int index, List<Integer> partAns){

        if(index == nums.length){
            ans.add(new ArrayList<>(partAns));

            return;
        }
        getSubsets(nums,ans,index+1,partAns);

        partAns.add(nums[index]);
        
        getSubsets(nums,ans,index+1,partAns);

        partAns.remove(partAns.size()-1);



    }
}