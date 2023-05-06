import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int y, int x, int cnt, int dir) {    // dir 1:가로 2: 세로 3: 대각선
        if (y == N - 1 && x == N - 1) {
            answer++;
        }

        int ny, nx;
        if (dir == 1) {
            // 가로 이동
            ny = y;
            nx = x + 1;
            if (ny < N && nx < N && arr[ny][nx]!=1) {
                dfs(ny, nx, cnt + 1, 1);
            }
        } else if (dir == 2) {
            // 세로 이동
            ny = y + 1;
            nx = x;
            if (ny < N && nx < N && arr[ny][nx]!=1) {
                dfs(ny, nx, cnt + 1, 2);
            }

        } else {
            // 가로 이동
            ny = y;
            nx = x + 1;
            if (ny < N && nx < N && arr[ny][nx]!=1) {
                dfs(ny, nx, cnt + 1, 1);
            }
            // 세로 이동
            ny = y + 1;
            nx = x;
            if (ny < N && nx < N && arr[ny][nx]!=1) {
                dfs(ny, nx, cnt + 1, 2);
            }
        }
        // 대각선 이동
        ny = y + 1;
        nx = x + 1;
        if (ny < N && nx < N && arr[ny][nx]!=1 && arr[y][nx]!=1 && arr[ny][x]!=1) {
            dfs(ny, nx, cnt + 1, 3);
        }
    }
}
