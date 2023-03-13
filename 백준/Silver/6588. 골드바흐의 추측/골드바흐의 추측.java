import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            boolean canGold = false;
            for (int i = 3; i <= n / 2; i++) {
                if (!isPrime[i]) {
                    int temp = n - i;
                    if (!isPrime[temp]) {
                        canGold = true;
                        bw.write(n + " = " + i + " + " + temp + "\n");
                        break;
                    }
                }
            }
            if (canGold == false) bw.write("Goldbach's conjecture is wrong.\n");
            n = Integer.parseInt(br.readLine());
        }
        bw.flush();
        bw.close();
    }
}
