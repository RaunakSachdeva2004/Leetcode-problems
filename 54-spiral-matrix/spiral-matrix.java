class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0; 
        int right = matrix[0].length-1;

        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix == null)
            return res;

        while(left<=right  && top  <=bottom){
            
        // traversing right
        for(int i =left ; i<=right; i++ ){
            res.add(matrix[top][i]);
        }
        top++;

        //traversing down
        for(int i = top; i<= bottom; i++){
            res.add(matrix[i][right]);

        }
        right--;

        if(top <= bottom){
            //traversing left
            for(int i = right; i>= left; i--){
                res.add(matrix[bottom][i]);

            }   
            bottom--;     
        }

        //traversing up
        if(left<=right){
            for(int i =bottom; i>=top; i-- ){
                res.add(matrix[i][left]);
            }
            left++;
        }
    }

    return res;
}
}