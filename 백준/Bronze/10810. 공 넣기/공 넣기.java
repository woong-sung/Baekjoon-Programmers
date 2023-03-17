import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[N];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for (int j = from - 1; j < to; j++) {
                arr[j] = num;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
