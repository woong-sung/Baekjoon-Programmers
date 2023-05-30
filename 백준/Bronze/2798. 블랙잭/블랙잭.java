import java.util.Scanner;

public class Main{
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		String[] str = sc.nextLine().split(" ");
		int[] arr = new int[N];
		for(int i =0 ; i<N ; i ++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		int sum = 0;
		for(int n =0; n<N-2;n++) {
			
			for(int i = n+1; i< N;i++) {
			
				for(int j = i+1; j<N;j++) {
				
					int sum2 = arr[n] + arr[i] + arr[j];
					if(sum<sum2 && sum2<=M) {
						sum = sum2;
					}
				}
			}
		}
		System.out.println(sum); 
		sc.close();
	}
}