class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        boolean [][]visited = new boolean [row][col];

        for(int i=0;i<col;i++){
            if(board[0][i]=='O'){
                dfs(0,i,visited,board);
            }
            if(board[row-1][i]=='O'){
                dfs(row-1,i,visited,board);
            }
        }

        for(int i=0;i<row;i++){
            if(board[i][0]=='O'){
                dfs(i,0,visited,board);
            }
            if(board[i][col-1]=='O'){
                dfs(i,col-1,visited,board);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(int x, int y, boolean[][] visited, char[][] board){

        visited[x][y]=true;

        System.out.println(x+"  "+y);
        int row= board.length;
        int col= board[0].length;
        
        int[] delRow={-1,+1,0,0};
        int[] delCol={0,0,-1,+1};

        for(int i=0;i<4;i++){
            int nRow = x + delRow[i];
            int nCol = y + delCol[i];

            if(nRow>=0 && nRow<row && nCol>=0 && nCol<col && !visited[nRow][nCol] && (board[nRow][nCol]=='O')){
                dfs(nRow,nCol,visited,board);
            }
        }
    }
}