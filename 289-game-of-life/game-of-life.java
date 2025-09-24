class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[] neighbours = {0, 1, -1};

        for(int row = 0; row < rows; row++){
            for(int col = 0; col<cols; col++){
                int live = 0;
                for(int i = 0; i< 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(!(neighbours[i] ==0 && neighbours[j] == 0))
                        {
                            int r = row + neighbours[i];
                            int c = col + neighbours[j];

                            if((r<rows && r>=0) && (c<cols && c>=0) && (Math.abs(board[r][c]) == 1) )
                                live++;
                        }
                    }
                }


                if ((board[row][col] == 1) && (live < 2 || live> 3)) {
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;
                }
                // Rule 4
                if (board[row][col] == 0 && live == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
                    }
            }
        }
         for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}