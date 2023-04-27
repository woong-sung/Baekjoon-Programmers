import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        boolean[][] visit = new boolean[N+1][N+1];
        int[][] times = new int[N+1][N+1];
        List<Integer>[] list = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
            Arrays.fill(times[i], 25000000);
        }
        for(int i =0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int time = road[i][2];
            list[from].add(to);
            list[to].add(from);
            times[from][to] = Math.min(times[from][to], time);
            times[to][from] = Math.min(times[to][from], time);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        times[0][1] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                if(visit[cur][next]) continue;
                visit[cur][next] = true;
                q.add(next);
                int newTime = times[0][cur] + times[cur][next];
                if (newTime <times[0][next]){
                    times[0][next] = newTime;
                    Arrays.fill(visit[next],false);
                }
                // times[0][next] = Math.min(times[0][next], times[0][cur] + times[cur][next]);
            }
        }
        for(int t : times[0]){
            System.out.println(t);
            if(t<=K) answer++;
        }
        return answer;
    }
}