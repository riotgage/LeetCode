class Solution {
    public boolean exist(char[][] board, String word) {
        int rows =  board.length;
        int cols =  board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==word.charAt(0)){
                    if(wordExists(i,j,board,word,0,rows,cols)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean wordExists(int x,int y,char[][] board, String word,int index,int rows,int cols){

        if(index == word.length()){
            return true;
        }
   
        if(x<0 || x>=rows || y<0 || y>=cols || board[x][y] !=word.charAt(index) || board[x][y]=='!')
            return false;

        char c = board[x][y];
        board[x][y] = '!';

        boolean top = wordExists(x - 1, y,board, word,  index + 1, rows, cols);
        // right direction
        boolean right = wordExists( x, y + 1,board, word, index + 1, rows, cols);
        // bottom direction
        boolean bottom = wordExists( x + 1, y,board, word, index + 1, rows, cols);
        // left direction
        boolean left = wordExists( x, y - 1,board, word, index + 1, rows, cols);

        board[x][y] = c; // undo change

        return top || right || bottom || left;

    }

    
}