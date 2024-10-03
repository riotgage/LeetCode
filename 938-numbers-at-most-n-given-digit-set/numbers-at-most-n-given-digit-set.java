class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int ans = 0;

        String numString = Integer.toString(n);
        int length = numString.length();
        int digitCount = digits.length;

        for(int i=1;i<length;i++){
            ans+=(int) Math.pow(digitCount,i);
        }
        ans += countNumbers(digits,numString,0);
        return ans;
    }



    public int countNumbers(String[] digits, String numString,int index){

        if(index == numString.length()){
            return 1;
        }

        int currentDigit = numString.charAt(index)-'0';
        int count =0;

        for(String d: digits){
            int dVal = Integer.parseInt(d);

            if(dVal < currentDigit){
                count += Math.pow(digits.length, numString.length() - index - 1);
            }  else if (dVal == currentDigit) {
                count += countNumbers(digits, numString, index + 1);
            } else {
                break;
            }
        }

        return count;
    }
}

