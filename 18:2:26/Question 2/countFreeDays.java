import java.util.*;

class Solution {
    public long countFreeDays(long days, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        long busyDays = 0;

        long start = meetings[0][0];
        long end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {

            if (meetings[i][0] <= end) {
                end = Math.max(end, meetings[i][1]); // merge
            } else {
                busyDays += (end - start + 1);
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }

        busyDays += (end - start + 1); // last interval

        return days - busyDays;
    }
}
