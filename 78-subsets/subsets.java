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
        // Ignoring the first element in array
        getSubsets(nums,ans,index+1,partAns);

        // Add the element and generate all the subsets which will have this one elem
        partAns.add(nums[index]);
        
        getSubsets(nums,ans,index+1,partAns);

        // We generated all subsets with currrent elem remove it and generate subsets without it
        partAns.remove(partAns.size()-1);

    }
}