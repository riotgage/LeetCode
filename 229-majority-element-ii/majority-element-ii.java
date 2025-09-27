class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        List<Integer> elements = new ArrayList<>();
        int thresholdLength = nums.length/3;
        for(int i=0;i<nums.length;i++){

            int count = elementCountMap.getOrDefault(nums[i],0);
            elementCountMap.put(nums[i],count+1);
            if(count==thresholdLength){
                elements.add(nums[i]);
            }
        }
        return elements;
    }
}