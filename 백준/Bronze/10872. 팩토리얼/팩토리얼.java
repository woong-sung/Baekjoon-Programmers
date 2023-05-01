import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int fac = 1;
		if (N==0) {
			fac =1;
		}else {
			for(int i =N;i>0;i-=1) {
				fac*=i;
			}
		} 
		System.out.println(fac);
	}
}