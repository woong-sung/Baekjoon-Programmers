import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int H = Integer.parseInt(str[1]);
        int[] sum = new int[H + 1];

        for (int i = 0; i < N; i++) {
            int stage = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                sum[stage]++;
            } else {
                sum[H]++;
                sum[H - stage]--;
            }
        }
        int min = sum[H];
        for (int i = H - 1; i > 0; i--) {
            sum[i] += sum[i + 1];
            min = Math.min(min, sum[i]);
        }
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            if (sum[i] == min) cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}
