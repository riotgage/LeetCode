class Solution {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;

        if(length==0){
            return 0;
        }

        int longest = 1;
        Set<Integer> elements = new HashSet<Integer>();
        
        for (int i = 0; i < length; i++) {
            elements.add(nums[i]);
        }

        for(int it: elements){

            // of it-1 exists. 'it' will be calculated in that sequence.
            if(elements.contains(it-1)){
                continue;
            }
            
            int cnt = 1;
            int x = it;
            while(elements.contains(x+1)){
                cnt++;
                x++;
            }
            longest = Math.max(longest,cnt);
            
        }
        return longest;
    }
}