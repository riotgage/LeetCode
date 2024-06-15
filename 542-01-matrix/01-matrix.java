class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        int [][] dist = new int[rows][cols];        
        boolean[][] visited = new boolean[rows][cols];

        Queue<node> q= new LinkedList<>();

        for(int i=0; i < rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    q.add(new node(i,j));
                    visited[i][j]=true;
                    dist[i][j] = 0;
                }
                else{
                    visited[i][j]=false;
                }
            }
        }

	    int delcol[] = {0, +1, 0, -1};
	    int delrow[] = {-1, 0, +1, 0}; 

        while(!q.isEmpty()){
            int x= q.peek().x;
            int y = q.peek().y;
            int steps = dist[x][y];
            q.remove();

            dist[x][y]=steps;
            

            for(int i=0;i<4;i++){
                int nrow= x+delrow[i];
                int ncol= y+delcol[i];
                if(nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols
	            && visited[nrow][ncol] == false)  {
	                    visited[nrow][ncol] = true; 
    	            q.add(new node(nrow, ncol));
                    dist[nrow][ncol] = steps + 1 ;  
	            } 
            }
        }
        return dist;
    }
}

class node{
    int x;
    int y;

    public node(int x,int y){
        this.x = x;
        this.y = y;
    }
}