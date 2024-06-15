class Solution {
    public int numEnclaves(int[][] grid) {

     int row = grid.length;
        int col = grid[0].length;
        int ans=0;
        boolean[][] visited = new boolean [row] [col];

        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<col;i++){

               
            // First row
            if(grid[0][i] == 1 && visited[0][i] == false){
                visited[0][i] = true;
                q.add(new Node(0,i));
            }
            // last row
            if(grid[row-1][i] == 1 && visited[row-1][i] == false){
                visited[row-1][i] = true;
                q.add(new Node(row-1,i));
            }
        }

        for(int i=0;i<row;i++){

            // first col
            if(grid[i][0] == 1 && visited[i][0] == false){
                visited[i][0] = true;
                q.add(new Node(i,0));
            }

            // last col
            if(grid[i][col-1] == 1 && visited[i][col-1] == false){
                visited[i][col-1] = true;
                q.add(new Node(i,col-1));
            }
        }

        int[] delRow={-1,1,0,0};
        int[] delCol={0,0,1,-1};

        while(!q.isEmpty()){

            int x = q.peek().first;
            int y = q.peek().second;

            q.remove();

            for(int i=0;i<4;i++){
                int nRow = x + delRow[i];
                int nCol = y + delCol[i];
           
                if(nRow>=0 && nRow<row && nCol>=0 && nCol<col && !visited[nRow][nCol] && grid[nRow][nCol]==1){
                    visited[nRow][nCol] = true;
                    q.add(new Node(nRow,nCol));
                }
            }


        }

                for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    ans++;
                }
            }
        }

        return ans;
   
    }

}

class Node{
    int first;
    int second;

    public Node(int first,int second){
        this.first = first;
        this.second = second;
    }
}