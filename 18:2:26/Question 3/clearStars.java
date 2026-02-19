import java.util.*;

class Solution {
    public String clearStars(String s) {

        List<Stack<Integer>> pos = new ArrayList<>();
        for (int i = 0; i < 26; i++) pos.add(new Stack<>());

        boolean[] removed = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '*') {

                for (int c = 0; c < 26; c++) {
                    if (!pos.get(c).isEmpty()) {
                        int idx = pos.get(c).pop();
                        removed[idx] = true;
                        break;
                    }
                }

            } else {
                pos.get(ch - 'a').push(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*' && !removed[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
