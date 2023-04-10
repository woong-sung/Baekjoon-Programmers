import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (n%i==0) k--;
            if (k==0) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
