class Solution {
    public int reverse(int x) {
        
        int num=0;
        boolean isNeg=false;   
        if(x<0){
            isNeg=true;
            x=x*-1;
        }
        while(x>0){
            int dig=x%10;
            x=x/10;
            
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && dig>7)) return 0;
            if (num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE / 10 && dig < -8)) return 0;
            num=num*10+dig;
            
            
        }
        if(isNeg)num*=-1;
        return num;
    }
}