import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            reverse(from, to, N);
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void reverse(int from, int to, int N) {
        int[] arr2 = new int[N + 1];
        for (int i = 1; i < from; i++) {
            arr2[i] = arr[i];
        }
        for (int i = from; i <= to; i++) {
            arr2[i] = arr[to - i + from];
        }
        for (int i = to + 1; i <= N; i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;
    }
}
