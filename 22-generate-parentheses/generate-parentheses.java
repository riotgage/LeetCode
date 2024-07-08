class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        getPar(ans,"",0,0,n);

        return ans;
    }

    public void getPar(List<String> ans, String partAns, int open, int close,int n){

        if(open > n || close > open || partAns.length()>2*n){
            return;
        }

        if(partAns.length() == 2*n){
            ans.add(partAns);
        }   
        getPar(ans,partAns+"(",open+1,close,n);
        getPar(ans,partAns+")",open,close+1,n);
    }
}