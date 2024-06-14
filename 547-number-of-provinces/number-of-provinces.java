class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int vertices = isConnected.length;
        int [] vis = new int[vertices];
        int ans =0;
        for(int i=0;i<vertices;i++){
            if(vis[i]==0){
                ans++;
                dfs(i,vis,isConnected);
            }
        }
        return ans;
    }

    public void dfs(int vertex, int [] vis,int[][] isConnected ){
        vis[vertex]=1;

        for(int i=0;i<isConnected[vertex].length;i++){
            if(isConnected[vertex][i]==1 && vis[i]==0){
                dfs(i,vis,isConnected);
            }
        }
    }
}