import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, K, answer;
    static int[][] arr, rcs;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMK = br.readLine().split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        K = Integer.parseInt(NMK[2]);
        arr = new int[N][M];
        visit = new boolean[K];
        rcs = new int[K][3];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }
        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]) - 1;
            int c = Integer.parseInt(str[1]) - 1;
            int s = Integer.parseInt(str[2]);
            rcs[i][0] = r;
            rcs[i][1] = c;
            rcs[i][2] = s;
        }
        int[][] copy = copy(arr);
        dfs(0, copy);
        System.out.println(answer);
    }
    public static int[][] copy(int[][] arr){
        int[][] result = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].clone();
        }
        return result;
    }

    public static void dfs(int cur, int[][] copy) {
        if (cur == K) {
            answer = Math.min(answer, cal(copy));
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visit[i]) {
                int r = rcs[i][0];
                int c = rcs[i][1];
                int s = rcs[i][2];
                visit[i] = true;
                dfs(cur + 1, go(r, c, s, copy(copy)));
                visit[i] = false;
            }
        }
    }

    public static int cal(int[][] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[0].length; j++) {
                sum += array[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    public static int[][] go(int r, int c, int s, int[][] copied) {
        for (int i = 0; i < s; i++) {
            copied = rotate(r - s + i, c - s + i, (s-i)*2, copied);
        }
        return copied;
    }

    public static int[][] rotate(int y, int x, int c, int[][] array) {
        int temp = array[y][x + c];
        for (int i = 0; i < c; i++) {
            array[y][x + c - i] = array[y][x + c - i - 1];
        }
        for (int i = 0; i < c; i++) {
            array[y + i][x] = array[y + i + 1][x];
        }
        for (int i = 0; i < c; i++) {
            array[y + c][x + i] = array[y + c][x + i + 1];
        }
        for (int i = 0; i < c - 1; i++) {

            array[y + c - i][x + c] = array[y + c - i - 1][x + c];
        }
        array[y+1][x + c] = temp;
        return array;
    }
}