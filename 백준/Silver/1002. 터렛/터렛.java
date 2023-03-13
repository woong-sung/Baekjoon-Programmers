import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<N;i++) {
			String[] str = sc.nextLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int r1 = Integer.parseInt(str[2]);
			int x2 = Integer.parseInt(str[3]);
			int y2 = Integer.parseInt(str[4]);
			int r2 = Integer.parseInt(str[5]);
			int cnt = 0;
			double d = Math.sqrt((double)Math.pow(Math.abs(x1-x2),2) + (double)Math.pow(Math.abs(y1-y2),2));

			if(r1+r2>d&&d>Math.abs(r1-r2)) {
				cnt = 2;
			}else if(r1+r2==d) {
				cnt = 1;
			}else if(d!=0 && Math.abs(r1-r2)==d) {
				cnt = 1;

			}else if(r1+r2<d||d<Math.abs(r1-r2)) {
				cnt =0;
			}else if(d==0 && r1!=r2) {
				cnt =0;
			}else if(d==0 && r1==r2) {
				cnt = -1;
			}
			System.out.println(cnt);
		}
	}
}