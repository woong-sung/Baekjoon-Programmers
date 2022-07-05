import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] all = new int[n];
        int[][] arr = new int[n + 2][3];
        for (int i = 0; i < n; i++) {
            all[i] = sc.nextInt();
        }
        int sum = 0;

        arr[0][0] = arr[0][1] = arr[0][2] = 0;
        arr[1][0] = arr[1][1] = arr[1][2] = 0;
        arr[2][0] = arr[2][1] = arr[2][2] = all[0];
        for (int i = 3; i < n + 2; i++) {
            arr[i][0] = Math.max(Math.max(arr[i - 2][1], arr[i - 2][0]), arr[i - 2][2]) + all[i - 2];
            arr[i][1] = Math.max(Math.max(arr[i - 3][1], arr[i - 3][0]), arr[i - 3][2]) + all[i - 2];
            arr[i][2] = Math.max(arr[i - 1][1], arr[i - 1][0]) + all[i - 2];
        }
        for (int i = 1; i < n + 2; i++) {
            sum = Math.max(arr[i][0], sum);
            sum = Math.max(arr[i][1], sum);
            sum = Math.max(arr[i][2], sum);
        }
        System.out.println(sum);
    }
}