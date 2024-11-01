class Solution {
    public int characterReplacement(String s, int k) {
          Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLength = 0, maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            
            // Update the max frequency of a single character in the window
            maxFreq = Math.max(maxFreq, charCount.get(currentChar));

            // If the current window size minus maxFreq exceeds k, move the left pointer
            if ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++; // Shrink the window from the left
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}