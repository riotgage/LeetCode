class Solution {
     public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Move all positive integers to the beginning of the array
        int positiveCount = segregate(nums);

        // Place each number in its correct position if it's within the range [1, positiveCount]
        for (int i = 0; i < positiveCount; i++) {
            while ( nums[i] <= positiveCount && nums[i] != nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        for (int i = 0; i < positiveCount; i++) {
            if (nums[i] != i + 1) {
                return i + 1; 
            }
        }
        
        return positiveCount + 1;
    }

    // Segregates positive numbers to the beginning and returns the count of positive numbers
    private static int segregate(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                // Swap positive numbers to the front
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }
}