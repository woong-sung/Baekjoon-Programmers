import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static long[] arr;
	public static void main(String[] args) {
		int N = sc.nextInt();
		arr = new long[101];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			P(num);
			System.out.println(arr[num]);
		}
	}

	public static void P(int k) {
		for(int i=1;i<=k;i++) {
			if (i == 1 || i == 2 || i == 3) {
				arr[i] = 1;
			} else if (i == 4 || i == 5) {
				arr[i] = 2;
			} else {
				arr[i] = arr[i - 1] + arr[i - 5]; 
			}
		}
		return;
	}
}