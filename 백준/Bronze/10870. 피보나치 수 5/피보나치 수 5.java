import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(0);
		fib.add(1);
		for(int i=2; i<=n;i++) {
			fib.add(fib.get(i-2)+fib.get(i-1));
		}
		System.out.println(fib.get(n));
	}
}