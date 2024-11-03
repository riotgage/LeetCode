class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()==0 || t.length()==0 || t.length()>s.length())return "";

        Map<Character,Integer> tFreq = new HashMap<>();

        for(char c: t.toCharArray()){
            tFreq.put(c,tFreq.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        int required = tFreq.size();
        int have = 0;
        int len = s.length();

        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int[] result = {-1, 0, 0};
        
        while(right<len){
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar,windowFreq.getOrDefault(rightChar, 0) + 1);

            if (tFreq.containsKey(rightChar) && windowFreq.get(rightChar).intValue() == tFreq.get(rightChar).intValue()) {
                have++;
            }

            while (have == required) {
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    have--;
                }

                left++; // Move left pointer to reduce window size
            }
            right++;
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}