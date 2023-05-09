import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[N];
        sum[0] = A[0];
        for (int i = 1; i < N; i++) {
            sum[i] = A[i] + sum[i - 1];
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (sum[i] == M) {
                cnt++;
            }else {
                int temp = sum[i];
                for (int j = 0; j < i; j++) {
                    temp -= A[j];
                    if (temp == M) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}