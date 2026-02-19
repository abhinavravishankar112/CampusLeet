import java.util.*;

class Solution {
    public int minimumDifference(int[] nums, int k) {

        Set<Integer> prev = new HashSet<>();
        int ans = Integer.MAX_VALUE;

        for (int num : nums) {

            Set<Integer> curr = new HashSet<>();

            curr.add(num);
            ans = Math.min(ans, Math.abs(k - num));

            for (int val : prev) {
                int or = val | num;
                curr.add(or);
                ans = Math.min(ans, Math.abs(k - or));
            }

            prev = curr;
        }

        return ans;
    }
}
