class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int row = image.length;
        int col = image[0].length;
        int initColor = image[sr][sc];
        int [][] ans = image;
        
        int[] dy={1,-1,0,0};

        int[] dx={0,0,1,-1};

        Queue<Pair<Integer,Integer>> q = new LinkedList<>();

        q.add(new Pair<>(sr,sc));

        while(!q.isEmpty()){

            int r = q.peek().getKey();
            int c = q.peek().getValue();
            q.poll();
                
            ans[r][c] = color;
            
            for(int i=0;i<4;i++){
                
                int nrow = r + dx[i];
                int ncol = c + dy[i];

                if((nrow>=0 && nrow<row) && (ncol>=0 && ncol<col) && image[nrow][ncol] == initColor && ans[nrow][ncol] != color){
                    ans[nrow][ncol]=color;
                    q.add(new Pair<>(nrow,ncol));
                }   
            }
        }

        return ans;
    }
}