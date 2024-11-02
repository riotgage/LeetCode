class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0 ;
        int left =0;
        int len = s.length();
        Map<Character,Integer> charCount = new HashMap<>();
        for(int right =0;right<len;right++){
            char c=s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            while(charCount.size()==3){
                ans+=len-right;
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if(charCount.get(leftChar)==0) charCount.remove(leftChar);
                left++;
            }
        }
        return ans;
    }
}