class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = -1, m = matrix.length, n = matrix[0].length;
        List<Integer> res=  new ArrayList<Integer>();

        int dir =1;

        while(m >0 && n>0){
            for(int k = 0; k<n;k++){
                j += dir;
                res.add(matrix[i][j]);
            }
            m--;

            for(int k = 0; k<m;k++){
                i += dir;
                res.add(matrix[i][j]);
            }
            n--;

            dir*=-1;
        }

        return res;
    }
}