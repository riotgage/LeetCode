class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int child =0;
        int greed = 0;

        while(child <s.length && greed<g.length){
            if(s[child]>=g[greed]){
                child++;
                greed++;
                ans++;
            }else{
                child++;
            }
        }

        return ans;
    }
}