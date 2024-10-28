class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start =0,last = 0;
        int len = s.length();
        if(len==0)return 0;
        int ans = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(last<len){
            if(map.containsKey(s.charAt(last))) start = Math.max(map.get(s.charAt(last))+1,start);

            map.put(s.charAt(last),last);
            ans = Math.max(ans,last-start+1);
            last++;
        }

        return ans;
    }
}