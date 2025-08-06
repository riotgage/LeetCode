class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); //  prefix sum 0 has occurred once

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (prefixSumFreq.containsKey(sum - k)) {
                count += prefixSumFreq.get(sum - k);
            }

            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}