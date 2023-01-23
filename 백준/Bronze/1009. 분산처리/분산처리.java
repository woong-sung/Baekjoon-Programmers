import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			double a = Integer.parseInt(str.split(" ")[0]);
			double b = Integer.parseInt(str.split(" ")[1]);
			if(b%4==0) {
				b=4;
				}
			else {
				b=b%4;
			}
			
			int result = (int)Math.pow(a, b)%10;
			if(result ==0) result =10;
			System.out.println(result);
		}
		
	}

}
