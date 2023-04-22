import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visit = new boolean[n+1];
        List<ArrayList<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            links.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            links.get(from).add(to);
            links.get(to).add(from);
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while(!q.isEmpty()){
            int cnt = 0;
            while(!q.isEmpty()){
                int cur = q.poll();
                for (int i = 0; i < links.get(cur).size(); i++) {
                    int next = links.get(cur).get(i);
                    if (!visit[next]) {
                        visit[next] = true;
                        q2.add(next);
                        cnt++;
                    }
                }
            }
            q = q2;
            q2 = new LinkedList<>();
            if (cnt != 0) {
                answer = cnt;
            }
        }
        return answer;
    }
}