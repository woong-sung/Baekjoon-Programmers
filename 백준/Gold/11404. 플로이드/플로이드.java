import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] city = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    city[i][j] = 0;
                } else {
                    city[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // 입력
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]) - 1;
            int to = Integer.parseInt(str[1]) - 1;
            int cost = Integer.parseInt(str[2]);
            city[from][to] = Math.min(city[from][to], cost);
        }
        // 탐색 후 갱신
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (city[j][i] != Integer.MAX_VALUE && city[i][k] != Integer.MAX_VALUE) {
                        city[j][k] = Math.min(city[j][k], city[j][i] + city[i][k]);
                    }
                }
            }
        }
        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(city[i][j] + " ");
                } 
            }
            System.out.println();
        }
    }
}
