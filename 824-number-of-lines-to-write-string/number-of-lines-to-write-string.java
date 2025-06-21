class Solution {
    public int[] numberOfLines(int[] widths, String s) {
         final int MAX = 100;
        int lines = 1;
        int currWidth = 0;
        
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (currWidth + w <= MAX) {
                currWidth += w;
            } else {
                lines++;
                currWidth = w;
            }
        }
        
        return new int[]{lines, currWidth};
    }
}