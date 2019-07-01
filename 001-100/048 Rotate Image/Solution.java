class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
    
//     public void rotate(int[][] matrix) {
//         int k = -1;
//         int[] array = new int[matrix.length * matrix.length];
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 k++;
//                 array[k] = matrix[i][j];
//             }
//         }

//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = matrix.length - 1; j >= 0; j--) {
//                 matrix[j][i] = array[k];
//                 k--;
//             }
//         }
//     }
    
//     public void rotate(int[][] matrix) {
//         for(int i=0;i<matrix[0].length;i++){
//             for(int j=0;j<i;j++){
//                 int temp=matrix[i][j];
//                 matrix[i][j]=matrix[j][i];
//                 matrix[j][i]=temp;
//             }
//         }
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[0].length/2;j++){
//                 int temp=matrix[i][j];
//                 matrix[i][j]=matrix[i][matrix[0].length-1-j];
//                 matrix[i][matrix[0].length-1-j]=temp;
//             }
//         }
//     }
}
