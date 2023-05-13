import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        int start = 0;
        int end = 1;
        int answer = Integer.MAX_VALUE;
        while (true) {
            int diff = A[end] - A[start];
            if (end == N - 1 && diff < M) break;

            if (diff == M) {
                answer = diff;
                break;
            } else if (diff > M) {
                answer = Math.min(answer, diff);
                start++;
            } else {
                end++;
            }
        }
        System.out.println(answer);
    }
}
