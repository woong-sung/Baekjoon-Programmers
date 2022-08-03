import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] box;
    static int N, M, cnt;
    static Queue<Integer[]> q;

    public static void main(String[] args) throws IOException {
        final int[] xarr = new int[]{-1, 0, 1, 0};
        final int[] yarr = new int[]{0, -1, 0, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N은 세로 M은 가로
        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);
        cnt = 0;
        // box는 창고
        box = new int[N][M];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(str[j]);
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

            //4방향을 확인해서 0이 있으면 q에 해당좌표를 넣는다(1이 됐으므로)
            for (int i = 0; i < 4; i++) {
                if (find(y + yarr[i], x + xarr[i])) {
                    q.add(new Integer[]{y + yarr[i], x + xarr[i]});
                    box[y + yarr[i]][x + xarr[i]] = box[y][x] + 1;
                }
            }

        }
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

    public static boolean find(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M) return false;
        if (box[y][x] == 0) return true;
        return false;
    }
}
