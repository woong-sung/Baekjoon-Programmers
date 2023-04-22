import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 2;
        }
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    int match1 = graph[j][i];
                    int match2 = graph[i][k];
                    if (match1 == 1 && match2 == 1) {
                        graph[j][k] = 1;
                        graph[k][j] = -1;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (check(graph[i])==n) {
                answer++;
            }
        }
        return answer;
    }
    public int check(int[] arr){
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}