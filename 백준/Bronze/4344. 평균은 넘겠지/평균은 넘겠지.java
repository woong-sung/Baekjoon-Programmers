import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		for(int a=0;a<C;a++) {
		String[] arr = br.readLine().split(" ");
		int num = Integer.parseInt(arr[0]); 
		
		int sum = 0;
		for(int i=1;i<=num;i++) {
			sum = sum + Integer.parseInt(arr[i]);
		}
		int ave = sum/num;
		double cnt = 0;
		for(int i=1;i<=num;i++) {
			if (Integer.parseInt(arr[i])>ave) {
				cnt++;
			}
		}
		double A = cnt/num*100;
		System.out.printf("%.3f",A);
		System.out.println("%");
		}
	}
}
