# Solution 1 BFS
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int width = board.length;
        int height = board[0].length;
        for (int i = 0; i < width; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][height - 1] == 'O') {
                bfs(board, i, height - 1);
            }
        }

        for (int j = 0; j < height; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[width - 1][j] == 'O') {
                bfs(board, width - 1, j);
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = (board[i][j] == 'Y') ? 'O' : 'X';
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        int width = board.length;
        int height = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        queue.offer(j);

        while (!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();

            if (row == -1 || row == width || col == -1 || col == height) continue;
            if (board[row][col] != 'O') continue;

            board[row][col] = 'Y';

            queue.offer(row - 1);
            queue.offer(col);

            queue.offer(row + 1);
            queue.offer(col);

            queue.offer(row);
            queue.offer(col - 1);

            queue.offer(row);
            queue.offer(col + 1);
        }
    }
}

# Solution 2 DFS
class Solution {
    int n, m;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 1);
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 2);
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 1, j);
            }
            if (board[n - 1][j] == 'O') {
                dfs(board, n - 2, j);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j) {
        if (i >= n - 1 || i <= 0 || j >= m - 1 || j <= 0 || board[i][j] == 'X' || board[i][j] == '*') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
