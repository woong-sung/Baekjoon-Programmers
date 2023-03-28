import java.util.*;
class Solution {
        static int ans;
        static List<Integer>[] list;
        public int solution(int n, int[][] wires) {
            ans = Integer.MAX_VALUE;
            list = new ArrayList[101];
            for (int i = 0; i < 101; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < wires.length; i++) {
                int v1 = wires[i][0];
                int v2 = wires[i][1];
                list[v1].add(v2);
                list[v2].add(v1);
            }
            for (int i = 0; i < wires.length; i++) {
                int v1 = wires[i][0];
                int v2 = wires[i][1];
                cut(v1,v2);
            }
            return ans;
        }
        public void cut(int v1, int v2){

            int cnt1 = count(v1,v2);
            int cnt2 = count(v2,v1);

            ans = Math.min(ans, Math.abs(cnt1 - cnt2));
        }

        public int count(int v1,int v2) {
            int cnt = 1;
            Queue<Integer> q = new LinkedList<>();
            q.add(v1);
            boolean[] visited = new boolean[list.length];
            visited[v1] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for (int i = 0; i < list[cur].size(); i++) {
                    int next = list[cur].get(i);
                    if (visited[next] || next==v2) continue;
                    visited[next] = true;
                    q.add(list[cur].get(i));
                    cnt++;
                }
            }
            return cnt;
        }
    }