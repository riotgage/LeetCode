class Solution {
    public int minTimeToType(String word) {
        
        char lastChar = 'a';
        int secs = 0;
        for(char c: word.toCharArray()){
            int moves = Math.min(Math.abs(c-lastChar),26-Math.abs(lastChar-c))+1;
            System.out.println(moves);
            secs+=moves;
            lastChar = c;
        }
        return secs;
    }
}