import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] all = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(all[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            int y = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            if (all[y][x] > w) all[y][x] = w;
        }
        String[] startend = br.readLine().split(" ");
        int start = Integer.parseInt(startend[0]);
        int end = Integer.parseInt(startend[1]);

        long[] startarr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            startarr[i] = all[start][i];
        }
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            int idx = 1;
            long min = Integer.MAX_VALUE;
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;
                if (min > startarr[j]) {
                    min = startarr[j];
                    idx = j;
                }
            }
            visited[idx] = true;
            for (int j = 1; j <= N; j++) {
                startarr[j] = Math.min(startarr[j], startarr[idx] + all[idx][j]);
            }
        }
        System.out.println(startarr[end]);
    }
}
