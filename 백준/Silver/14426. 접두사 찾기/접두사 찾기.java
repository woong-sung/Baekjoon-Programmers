import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        int N = Integer.parseInt(NM.split(" ")[0]);
        int M = Integer.parseInt(NM.split(" ")[1]);

        HashSet<String> S = new HashSet<>();
        // contains의 실행속도가
        // list는 O(N)이지만 set의 경우는 O(1)이다.
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String check = br.readLine();
            boolean done = false;
            for (String str : S) {
                int len = check.length();
                for (int j = 0; j < len; j++) {
                    if (str.charAt(j) != check.charAt(j)) {
                        break;
                    }
                    if (j == len - 1) {
                        cnt++;
                        done = true;
                    }
                }
                if (done) break;
            }
        }
        System.out.println(cnt);
    }
}
