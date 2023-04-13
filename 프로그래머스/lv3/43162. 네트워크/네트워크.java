import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }
        boolean[] checked = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (checked[i]) continue;
            q.add(i);
            answer++;
            while (!q.isEmpty()) {
                int cur = q.poll();

                checked[cur] =true;
                for (int next : list[cur]) {
                    if (checked[next]) continue;
                    checked[next] = true;
                    q.add(next);
                }
            }
        }
        return answer;
    }
}