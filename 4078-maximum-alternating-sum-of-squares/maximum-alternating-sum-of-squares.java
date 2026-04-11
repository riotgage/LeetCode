class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        long negSum = 0;
        long posSum = 0;
        int len = nums.length;
        int oddCount = len/2;

        for(int i=0;i<oddCount;i++){
            negSum += (long)arr[i]*arr[i];
            System.out.println(arr[i]);
        }

        for(int i=oddCount;i<len;i++){
            posSum += (long)arr[i]*arr[i];
        }

        return posSum-negSum;
    }
}