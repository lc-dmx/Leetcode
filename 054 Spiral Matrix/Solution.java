Solution 1: Simulation

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }

        int col = matrix[0].length;
        int length = row * col;

        boolean[][] visited = new boolean[row][col];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0, di = 0;

        for (int i = 0; i < length; i++) {
            result.add(matrix[r][c]);
            visited[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];

            if (cr >= 0 && cr < row && cc >= 0 && cc < col && !visited[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return result;
    }
}

Complexity Analysis

* Time Complexity: O(N), where N is the total number of elements in the input matrix. We add every element in the matrix to our final answer.

* Space Complexity: O(N), the information stored in seen and in ans. 

Solution 2: Layer-by-layer


