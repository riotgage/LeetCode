class Solution {
    public int maxDistance(int[] colors) {
        int left = 0;
        int right = colors.length -1;
        int max =0 ;

        // Compare every home with first
        for( ; right>0 ; right--){
            if(colors[0] != colors[right]){
               max= right;
               break;
            }
        }

        // Compare every home with last
        for (; left < colors.length; left++){
             if(colors[left] != colors[colors.length -1]){
               max= Math.max(max, Math.abs( left - (colors.length -1) ) );
               break;
            }
        }

     return max;
    }
}