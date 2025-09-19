class Solution {
    public void rotate(int[][] matrix) {
      
        int n = matrix.length;

        // The outer loop runs for n/2 layers.
        for (int i = 0; i < n / 2; i++) {
            // The inner loop handles the elements from the start of the layer to just before the end.
            for (int j = i; j < n - 1 - i; j++) {
                // --- Start 4-way swap ---

                //temp = bottom left
                int temp = matrix[i][j];

                //bottom left = bottom right
                matrix[i][j] = matrix[n - 1 - j][i];

               //bottm right = top right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                //top right = top left
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                //top left = temp
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}