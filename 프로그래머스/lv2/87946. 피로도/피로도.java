
class Solution {
    static boolean[] visit;
    static int[][] dungeonss;
    static int max;
        public static int solution(int k, int[][] dungeons) {
            int len = dungeons.length;
            visit = new boolean[len];
            dungeonss = dungeons;
            dfs(0,len,k);
            return max;
        }

        private static void dfs(int cur, int len, int p) {
            if (len == cur){
                max = Math.max(max, cur);
                return;
            }

            for (int i = 0; i < len; i++) {
                if (visit[i]) continue;

                int needP = dungeonss[i][0];
                int consumeP = dungeonss[i][1];
                if (p<needP || p<consumeP) {
                    max = Math.max(max, cur);
                    continue;
                }
                visit[i] = true;
                dfs(cur+1,len,p-consumeP);
                visit[i] = false;
            }

        }
    }