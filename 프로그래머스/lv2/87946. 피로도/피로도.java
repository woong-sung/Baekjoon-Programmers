class Solution {
    static boolean[] visit;
    static int max;
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        visit = new boolean[len];
        dfs(dungeons,0,len,k);
        return max;
    }

    private void dfs(int[][] dungeons, int cur, int len, int p) {
            max = Math.max(max, cur);

        for (int i = 0; i < len; i++) {
            int needP = dungeons[i][0], consumeP = dungeons[i][1];
            if (visit[i] ||p<needP) continue;
            visit[i] = true;
            dfs(dungeons,cur+1,len,p-consumeP);
            visit[i] = false;
        }
    }
}