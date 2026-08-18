class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        int n = intervals.length;

        for(int i = 0;i < n; i++){
            int c = intervals[i][0], d = intervals[i][1];
            boolean iscovered = false;

            for(int j = 0; j < n; j++){
                int a = intervals[j][0], b = intervals[j][1];
                
                if(i != j && (a<=c && b>=d)){
                    iscovered = true;
                    break;
                }
            }

            if(!iscovered)
            count++;
        }

        return count;
    }
}