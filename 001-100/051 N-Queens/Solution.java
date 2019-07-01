class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] queen = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queen[i][j] = '.';
            }
        }

        NQueen(result, queen, 0);

        return result;
    }

    private void NQueen(List<List<String>> result, char[][] queen, int start) {
        int end = queen.length;
        if (start == end) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < end; i++) {
                list.add(String.valueOf(queen[i]));
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < end; i++) {
            if (isSafe(queen, i, start)) {
                queen[i][start] = 'Q';
                NQueen(result, queen, start + 1);
                queen[i][start] = '.';
            }
        }
    }

    private boolean isSafe(char[][] queen, int row, int col) {
        int end = queen.length;
//        for(int i = 0; i < end; i++) {
//            for(int j = 0; j < col; j++) {
//                if(queen[i][j] == 'Q' && (row + j == i + col || row + col == i + j || row == i)) {
//                    return false;
//                }
//            }
//        }
        /* Check this row on left side */
        for (int i = 0; i < col; i++) {
            if (queen[row][i] == 'Q') {
                return false;
            }
        }

        /* Check upper diagonal on left side */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (queen[i][j] == 'Q') {
                return false;
            }
        }

        /* Check lower diagonal on left side */
        for (int i = row, j = col; i < end && j >= 0; i++, j--) {
            if (queen[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
