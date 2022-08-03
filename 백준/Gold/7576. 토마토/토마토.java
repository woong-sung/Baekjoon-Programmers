import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] box;
    static int N, M, cnt;
    static Queue<Integer[]> q;

    public static void main(String[] args) throws IOException {
        //상하좌우 비교를 위한 방향
        final int[] dx = new int[]{-1, 0, 1, 0};
        final int[] dy = new int[]{0, -1, 0, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N은 세로 M은 가로
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cnt = 0;
        // box는 창고
        box = new int[N][M];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2);
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st2.nextToken());
                // 이미 익어있는(1인) 좌표를 큐에 넣는다.
                if (box[i][j] == 1) {
                    q.add(new Integer[]{i, j});
                    cnt++;
                }
            }
        }
        while (!q.isEmpty()) {
            Integer[] A = q.poll();
            int y = A[0];
            int x = A[1];
            for (int i = 0; i < 4; i++) {
                if (find(y + dy[i], x + dx[i])) {
                    //4방향을 확인해서 0이 있으면 q에 해당좌표를 넣는다(1이 됐으므로)
                    q.add(new Integer[]{y + dy[i], x + dx[i]});
                    // 그리고 해당칸에 이전칸의 수+1를 넣는다( 날짜표시 )
                    box[y + dy[i]][x + dx[i]] = box[y][x] + 1;
                }
            }

        }
        //
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    max = 0;
                    break;
                }
                max = Math.max(max, box[i][j]);
            }
            if (max == 0) break;
        }
        System.out.println(max - 1);
    }
    // 해당 칸이 경계 안에 있고 0인지 확인
    public static boolean find(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M) return false;
        if (box[y][x] == 0) return true;
        return false;
    }
}
