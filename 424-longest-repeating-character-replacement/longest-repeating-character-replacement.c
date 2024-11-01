int characterReplacement(char* s, int k) {
    int charCount[26] = {0}; // Array to store the frequency of each character
    int left = 0, maxLength = 0, maxFreq = 0;

    for (int right = 0; s[right] != '\0'; right++) {
        // Update frequency of the current character
        char currentChar = s[right];
        charCount[currentChar - 'A']++;
        
        // Update the maximum frequency of a single character in the window
        if (charCount[currentChar - 'A'] > maxFreq) {
            maxFreq = charCount[currentChar - 'A'];
        }

        // Check if we need to shrink the window
        if ((right - left + 1) - maxFreq > k) {
            char leftChar = s[left];
            charCount[leftChar - 'A']--;
            left++; // Shrink the window from the left
        }

        // Update the maximum length of the valid window
        int windowLength = right - left + 1;
        if (windowLength > maxLength) {
            maxLength = windowLength;
        }
    }

    return maxLength;
}