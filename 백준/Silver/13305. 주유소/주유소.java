import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N+1];
        int[] dis = new int[N];
        int[] min = new int[N+1];
        // 거리 받아오기
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        for (int i=1;i<N;i++){
            dis[i] = Integer.parseInt(st.nextToken());
        }
        // 비용 받아오기
        StringTokenizer st2 =new StringTokenizer(br.readLine()," ");
        for (int i=1;i<=N;i++){
            cost[i] = Integer.parseInt(st2.nextToken());
        }
        // 최소값배열
        min[1] =0;
        int[][] arr = new int[N][N+1];
//        arr[0][1] = 0;
        for (int i=1 ;i<N;i++){
            if(i>1){
                min[i] = arr[1][i];
                for(int j =1;j<i;j++){
                    min[i] = Math.min(arr[j][i],min[i]);
                }
            }
            for (int j=i+1;j<=N;j++){
                arr[i][j] = min[i] ;
                for (int c =i;c<j;c++) {
                    arr[i][j] += cost[i] * dis[c];
                }
            }

        }
        int result = arr[1][N];
        for (int i = 2; i < N; i++) {
            result = Math.min(result, arr[i][N]);
        }
        System.out.println(result);
    }
}