import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int cnt = 0;
        int[] all = new int[N];
        for (int i = 0; i < N; i++) {
            all[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N - 1; i >= 0; i--) {
            while (K >= all[i]) {
                cnt++;
                K -= all[i];
            }
        }
        System.out.println(cnt);
    }
}