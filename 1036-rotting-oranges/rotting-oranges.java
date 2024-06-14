class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int col= grid[0].length;
        int row = grid.length;
        Queue<Pair<Integer,Integer>> q= new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    count++;
                    }
                else if(grid[i][j]==2){
                    q.add(new Pair<>(i,j));
                }
            }
        }
        
        if(count == 0) return 0;
        int ans=0;
        int rotten=0;
        while(!q.isEmpty()){

            int size = q.size();
            
            int dx[] = {0, 0, 1, -1};
            int dy[] = {1, -1, 0, 0};
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> pair= q.poll();

                for(int j=0;j<4;j++){
                    int x = pair.getKey() + dx[j];
                    int y = pair.getValue() + dy[j];

                    if(x<0 || y<0 || x>=row || y>=col || grid[x][y]==0 || grid[x][y]==2){
                        continue;
                    }

                    grid[x][y]=2;
                    rotten++;
                    q.add(new Pair<>(x,y));
                }
            }

            if(q.size()!=0){
                ans++;
            }

        }

        if(count == rotten) return ans;

        return -1;


    }
}