class Solution {
    public int maxScore(String s) {
        int zeros = 0;
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }
        int ans = 0;
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            ans = Math.max(ans, zeros + ones);
        }
        return ans;
    }
}