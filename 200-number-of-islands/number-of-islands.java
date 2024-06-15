class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int [][] vis = new int[row][col];
        int cnt = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    cnt++;
                    dfs(i,j,vis,grid);
                }
            }
        }

        return cnt;
    }

    public void dfs(int row, int col,int [][] vis,char[][] grid){
        vis[row][col]=1;
        int[] delRow={-1,+1,0,0};
        int[] delCol={0,0,-1,+1};
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<4;i++){
            int nrow = row + delRow[i]; 
            int ncol = col + delCol[i]; 

            if(nrow>=0 && nrow<rows && ncol >=0 && ncol<cols && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                dfs(nrow,ncol,vis,grid);
            }
        }

    }
}