class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        long[] prefix = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + tasks[i];
        }
        
        long totalTaskTime = prefix[n];
        int[] ans = new int[m];
        long completedWork = 0;
        
        for (int j = 0; j < m; j++) {
            completedWork += shifts[j];
            
            if (completedWork >= totalTaskTime) {
                ans[j] = 0;
                completedWork = 0;
            } else {
                int tasksCompleted = binarySearch(prefix, completedWork);
                ans[j] = n - tasksCompleted;
            }
        }
        
        return ans;
    }
    
    private int binarySearch(long[] prefix, long target) {
        int left = 0;
        int right = prefix.length - 1;
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (prefix[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}