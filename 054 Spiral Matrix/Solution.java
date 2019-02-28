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

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                result.add(matrix[r1][c]);
            }

            for (int r = r1 + 1; r <= r2; r++) {
                result.add(matrix[r][c2]);
            }

            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    result.add(matrix[r2][c]);
                }

                for (int r = r2; r > r1; r--) {
                    result.add(matrix[r][c1]);
                }
            }

            r1++;
            c1++;
            r2--;
            c2--;
        }
        return result;
    }
}

Complexity Analysis

* Time Complexity: O(N), where N is the total number of elements in the input matrix. We add every element in the matrix to our final answer.

* Space Complexity: O(N), the information stored in ans.
