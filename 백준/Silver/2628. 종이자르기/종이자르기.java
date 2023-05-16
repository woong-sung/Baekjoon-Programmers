import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        boolean[] paper_width = new boolean[width + 1];
        boolean[] paper_height = new boolean[height + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (m == 1) paper_width[c] = true;
            else paper_height[c] = true;
        }
        int maxWid = 0;
        int maxHei = 0;
        int len = 0;
        for (int i = 1; i <= width; i++) {
            len++;
            if (paper_width[i] == true || i == width) {
                maxWid = Math.max(maxWid, len);
                len = 0;
            }
        }
        for (int i = 1; i <= height; i++) {
            len++;
            if (paper_height[i] == true || i == height) {
                maxHei = Math.max(maxHei, len);
                len = 0;
            }
        }
        System.out.println(maxWid * maxHei);
    }
}
