class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    // Using set to keep track of elements.   
    //   Set<List<Integer>> triplets = new HashSet<>();

    //   for(int i=0;i<nums.length;i++){
    //     Set<Integer> set = new HashSet<>();

    //     for(int j=i+1;j<nums.length;j++){
    //         int tar = -(nums[i]+nums[j]);

    //         if(set.contains(tar)){
    //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], tar);
    //                 temp.sort(null);
    //                 triplets.add(temp);
    //         }
    //         set.add(nums[j]);
    //     }
    //   }

    //   return new ArrayList<>(triplets);


    // Reusing 2 sum logic. Sort the array. fix one element and treat the right array
    // as 2 sum problem

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0;i<len;i++){

            if(i!=0 && nums[i]==nums[i-1])continue;

            int j = i+1;
            int k = len-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    // Avoid duplicates of same value
                    while(j<k && nums[j]==nums[j-1])j++;
                    while(j<k && nums[k]==nums[k+1])k--;
                }
            }
        }

        return ans;

    }
}