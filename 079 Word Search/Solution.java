# Solution 1
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (check(board, i, j, word, 0, new boolean[row][col])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, int i, int j, String word, int k, boolean[][] traveled) {
        if (!isSafe(board, i, j, traveled) || k >= word.length()) {
            return false;
        }

        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        traveled[i][j] = true;
        if (k + 1 == word.length()) {
            return true;
        }

        boolean result = check(board, i + 1, j, word, k + 1, traveled) ||
                check(board, i - 1, j, word, k + 1, traveled) ||
                check(board, i, j + 1, word, k + 1, traveled) ||
                check(board, i, j - 1, word, k + 1, traveled);

        traveled[i][j] = false;
        return result;
    }

    private boolean isSafe(char[][] board, int i, int j, boolean[][] traveled) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || traveled[i][j]) {
            return false;
        }
        return true;
    }
}

# Solution 2
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] traveled = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    traveled[i][j] = true;
                    if (check(board, i, j, word, 0, traveled)) {
                        return true;
                    }

                    for (int m = 0; m < traveled.length; m++) {
                        for (int n = 0; n < traveled[0].length; n++) {
                            if (traveled[m][n]) {
                                traveled[m][n] = false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, int i, int j, String word, int k, boolean[][] traveled) {
        int row = board.length;
        int col = board[0].length;
        if (k + 1 == word.length()) {
            return true;
        }

        if (i + 1 < row && board[i + 1][j] == word.charAt(k + 1) && !traveled[i + 1][j]) {
            traveled[i + 1][j] = true;
            if (check(board, i + 1, j, word, k + 1, traveled)) {
                return true;
            }
            traveled[i + 1][j] = false;
        }

        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(k + 1) && !traveled[i - 1][j]) {
            traveled[i - 1][j] = true;
             if (check(board, i - 1, j, word, k + 1, traveled)) {
                return true;
             }
            traveled[i - 1][j] = false;
        }

        if (j + 1 < col && board[i][j + 1] == word.charAt(k + 1) && !traveled[i][j + 1]) {
            traveled[i][j + 1] = true;
            if (check(board, i, j + 1, word, k + 1, traveled)) {
                return true;
            }
            traveled[i][j + 1] = false;
        }

        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(k + 1) && !traveled[i][j - 1]) {
            traveled[i][j - 1] = true;
            if (check(board, i, j - 1, word, k + 1, traveled)) {
                return true;
            }
            traveled[i][j - 1] = false;
        }

        return false;
    }
}
