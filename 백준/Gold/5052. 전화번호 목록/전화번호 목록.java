import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);
            boolean can = true;
            for (int j = 0; j < n-1; j++) {
                if (arr[j+1].startsWith(arr[j])) {
                    can=false;
                    break;
                }
            }
            if (can) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
