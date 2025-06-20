class Solution {
    public int minTimeToType(String word) {
        
        char lastChar = 'a';
        int secs = 0;
        for(char c: word.toCharArray()){
            int move = Math.abs(c-lastChar);
            secs+=Math.min(move,26-move)+1;
            lastChar = c;
        }
        return secs;
    }
}