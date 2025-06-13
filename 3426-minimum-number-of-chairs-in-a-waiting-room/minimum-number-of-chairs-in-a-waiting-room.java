class Solution {
    public int minimumChairs(String s) {
        int count = 0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='E'){
                count++;
            }else{
                count--;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}