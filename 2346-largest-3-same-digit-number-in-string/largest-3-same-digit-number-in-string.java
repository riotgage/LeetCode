class Solution {
    public String largestGoodInteger(String num) {
        char curr = '\0';

        for(int i=0;i<=num.length()-3;i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                curr = (char) Math.max(curr,num.charAt(i));
            }
        }
        return curr == '\0' ? "" : new String(new char[]{curr, curr, curr});
    }
}