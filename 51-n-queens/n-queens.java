class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> chessConfigurations = new ArrayList<>();

       char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        getSafeChessConfigurations(n,0,board,chessConfigurations);
        return chessConfigurations;

    }

    public void getSafeChessConfigurations(int chessSize, int column,char[][] board, List<List<String>> chessConfigurations){

        if(column == chessSize){
            chessConfigurations.add(createBoard(board,chessSize));
            return;
        }

        for(int row =0; row<chessSize;row++){
            if(checkViability(board,column,row,chessSize)){
                board[row][column]='Q';
                getSafeChessConfigurations(chessSize,column+1,board,chessConfigurations);
                board[row][column]='.';
            }
        }
    }

    private boolean checkViability(char [][] board, int col,int row,int n){

        for(int i=0;i<col;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }

        for(int i = row-1, j = col-1;i>=0 && j>=0;i--,j--){
             if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row + 1, j = col - 1; j >= 0 && i < n; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

     private List<String> createBoard(char[][] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

}