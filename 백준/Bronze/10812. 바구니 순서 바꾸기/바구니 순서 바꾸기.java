import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] basket = new int[N+1];
        for (int c = 0; c <= N; c++) {
            basket[c] = c;
        }
        for (int c = 0; c < M; c++) {
            int[] temp = basket.clone();
            int begin = sc.nextInt();
            int end = sc.nextInt();
            int mid = sc.nextInt();
            for (int l = 0; l <= end-begin; l++) {
                temp[begin + l] = basket[mid+l];
                if (mid+l>N) mid = begin-l-1;
                if (mid+l==end) mid = begin-l-1;
            }
            basket = temp;
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i]+" ");
        }
    }
}
