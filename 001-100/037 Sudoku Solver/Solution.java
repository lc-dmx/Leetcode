class Solution {
    public void solveSudoku(char[][] board) {
        //store the existed visited values
        boolean[][] rowVisited = new boolean[9][9];
        boolean[][] columnVisited = new boolean[9][9];
        boolean[][] boxVisited = new boolean[9][9];

        //initialize the visited board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                //非常巧妙的转换了一下
                int num = board[i][j] - '0' - 1;
                int key = (i / 3) * 3 + (j / 3) ;
                rowVisited[i][num] = true;
                columnVisited[j][num] = true;
                boxVisited[key][num] = true;
            }
        }

        dfs(board, 0, rowVisited, columnVisited, boxVisited);
    }

    private boolean dfs(char[][] board, int count, boolean[][] rowVisited, boolean[][] columnVisited, boolean[][] boxVisited) {
        //after we go through all the cells, we find the solution.
        if (count == 81) return true;

        for(int m = count; m < 81; m++) {
            int i = m / 9;
            int j = m % 9;
            if (board[i][j] != '.') continue;

            for (int num = 0; num < 9; num++) {
                int key = (i / 3) * 3 + (j / 3);
                if (rowVisited[i][num] || columnVisited[j][num] || boxVisited[key][num]) continue;

                board[i][j] = (char) (num + 49);
                rowVisited[i][num] = true;
                columnVisited[j][num] = true;
                boxVisited[key][num] = true;

                if (dfs(board, m + 1, rowVisited, columnVisited, boxVisited)) {
                    return true;
                }
                board[i][j] = '.';
                rowVisited[i][num] = false;
                columnVisited[j][num] = false;
                boxVisited[key][num] = false;
            }
            // for current value 1-9, we cannot find a solution, so we need to go back.
            return false;
        }
        //since there will be one unique solution, after go through all the values, there should be an true returned.
        return true;
    }
}
