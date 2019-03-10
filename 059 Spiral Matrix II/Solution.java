class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int k = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                result[r1][c] = k;
                k++;
            }

            for (int r = r1 + 1; r <= r2; r++) {
                result[r][c2] = k;
                k++;
            }

            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    result[r2][c] = k;
                    k++;
                }

                for (int r = r2; r > r1; r--) {
                    result[r][c1] = k;
                    k++;
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
