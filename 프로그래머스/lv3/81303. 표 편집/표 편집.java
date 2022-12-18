import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
            StringBuilder answer = new StringBuilder();

        int total = n;
        Stack<Integer> removed = new Stack<>();
        int cur = k;
        for (int i = 0; i < cmd.length; i++) {
            char move = cmd[i].charAt(0);

            if (move == 'D') {
                int go = Integer.parseInt(cmd[i].split(" ")[1]);
                cur += go;
            } else if (move == 'U') {
                int go = Integer.parseInt(cmd[i].split(" ")[1]);
                cur -= go;
            } else if (move == 'C') {
                total--;
                removed.add(cur);
                if (total == cur) cur--;
            } else if (move == 'Z') {
                int pre = removed.pop();
                if (pre <= cur) {
                    cur++;
                }
                total++;
            }
        }
        for (int i = 0; i < total; i++) {
            answer.append("O");
        }

        while (!removed.isEmpty()) {
            int pre = removed.pop();
            answer.insert(pre, "X");
        }
        return answer.toString();
    }
}