import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit, base;
    static int N,answer;
    static int[] order;
    static int[][] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        order = new int[9];
        points = new int[N][9];
        visit = new boolean[9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[0] = true;
        order[3] = 0;
        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int cur){
        if (cur == 9) {
            count();
            return;
        }
        if (cur==3) {
            dfs(cur+1);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visit[i]){
                visit[i] = true;
                order[cur] = i;
                dfs(cur+1);
                visit[i] = false;
            }
        }
    }
    public static void count(){
        int round = 0;
        int cur = 0;
        int point = 0;
        base = new boolean[4];
        while (round != N) {
            int out = 0;
            while (out != 3) {
                if (cur==9) cur = 0;
                int c = order[cur++];
                if (points[round][c] == 0) {
                    out++;
                } else {
                    point += getPoint(points[round][c]);
                }
            }
            base = new boolean[4];
            round++;
        }
        answer = Math.max(answer, point);
    }
    public static int getPoint(int p){
        int point = 0;

        if (p==1) {
            if (base[3]){
                point++;
                base[3] = false;
            } if (base[2]) {
                base[3] = true;
                base[2] = false;
            } if (base[1]){
                base[2] = true;
                base[1] = false;
            }
            base[1] = true;
        } else if (p == 2) {
            if (base[3]){
                point++;
                base[3] = false;
            } if (base[2]) {
                point++;
                base[2] = false;
            } if (base[1]){
                base[3] = true;
                base[1] = false;
            }
            base[2] = true;
        } else if (p == 3) {
            if (base[3]){
                point++;
                base[3] = false;
            } if (base[2]) {
                point++;
                base[2] = false;
            } if (base[1]){
                point++;
                base[1] = false;
            }
            base[3] = true;
        } else if (p == 4) {
            if (base[3]){
                point++;
                base[3] = false;
            } if (base[2]) {
                point++;
                base[2] = false;
            } if (base[1]){
                point++;
                base[1] = false;
            }
            point++;
        }
        return point;
    }
}