import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);
        int answer = 1;
        int left = 1;
        int right = houses[N - 1] - houses[0];
        int mid = (left + right) / 2;
        while(left<=right){
            if (check(houses, C, mid)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        System.out.println(answer);
    }

    public static boolean check(int[] arr, int c, int mid) {
        int cnt = 1;
        int last = arr[0];
        for (int house : arr) {
            if (house - last >= mid) {
                cnt++;
                last = house;
            }
        }
        return cnt >= c;
    }
}
