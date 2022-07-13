import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dis = new long[N-1];
        long[] cost = new long[N];
        // 거리 받아오기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
            dis[i] = Long.parseLong(st.nextToken());
        }
        // 비용 받아오기
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st2.nextToken());
        }
        // sum : 총합
        long sum = cost[0] * dis[0];
        // min_cost : i번째 도시까지 갔을때 최소 기름값
        long min_cost = cost[0];
        for (int i = 1; i < N-1; i++) {
            min_cost = Math.min(min_cost,cost[i]);
            sum += min_cost * dis[i];
        }
        System.out.println(sum);
    }
}