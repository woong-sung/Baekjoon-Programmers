import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long k = sc.nextInt();

        long start = 0;
        long end = N * N;

        while (start < end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(N, mid / i);
            }
            if (sum >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(end);
    }
}
