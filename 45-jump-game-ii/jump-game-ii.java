class Solution {
    public int jump(int[] nums) {

        int len = nums.length;
        if(len<2)return 0;
        // int[] minJumps = new int[len];

        // for(int i=0;i<len;i++){
        //     minJumps[i]=Integer.MAX_VALUE;
        // }
        // minJumps[0]=0;

        // for(int i=0;i<len;i++){
        //     int jump = nums[i];
        //     for(int j=1;j<=jump && i+j<len;j++){
        //         minJumps[i+j]=Math.min(minJumps[i+j],minJumps[i]+1);              
        //     }

        //     if(minJumps[len-1]!=Integer.MAX_VALUE)return minJumps[len-1];
        // }
        // return minJumps[len-1];

        int farthest=0,currentEnd =0;
        int jump=0;
        for(int i=0;i<nums.length;i++){
            farthest = Math.max(farthest,i+nums[i]);

            if(i==currentEnd){
                jump++;
                currentEnd = farthest;
            }

            if(currentEnd >= nums.length-1)return jump;
        }

        return jump;
    }
}