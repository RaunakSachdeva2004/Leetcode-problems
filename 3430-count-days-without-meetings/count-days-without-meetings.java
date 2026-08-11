import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int freeDays = 0;
        int latestEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            latestEnd = Math.max(latestEnd, end);
        }

        freeDays += days - latestEnd;
        return freeDays;
    }
}