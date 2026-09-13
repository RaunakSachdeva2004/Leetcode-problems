class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        // Store coordinates of all 1s in img1
        int[][] points1 = new int[n * n][2];
        int count1 = 0;

        // Store coordinates of all 1s in img2
        int[][] points2 = new int[n * n][2];
        int count2 = 0;

        // Find all 1s in both images
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {
                    points1[count1++] = new int[]{i, j};
                }

                if (img2[i][j] == 1) {
                    points2[count2++] = new int[]{i, j};
                }
            }
        }

        // Map: shift -> number of overlapping 1s
        HashMap<String, Integer> map = new HashMap<>();

        int ans = 0;

        // Try every pair of 1s
        for (int i = 0; i < count1; i++) {
            for (int j = 0; j < count2; j++) {

                int dx = points2[j][0] - points1[i][0];
                int dy = points2[j][1] - points1[i][1];

                String key = dx + "," + dy;

                int value = map.getOrDefault(key, 0) + 1;

                map.put(key, value);

                ans = Math.max(ans, value);
            }
        }

        return ans;
    }
}