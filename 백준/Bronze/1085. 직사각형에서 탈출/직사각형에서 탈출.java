import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int x = Integer.parseInt(str.split(" ")[0]);
		int y = Integer.parseInt(str.split(" ")[1]);
		int w = Integer.parseInt(str.split(" ")[2]);
		int h = Integer.parseInt(str.split(" ")[3]);
		int W=0;
		int H=0;
		
		if(w-x>x) {
			W= x;
		}else {
			W= w-x;
		}
		
		if(h-y>y) {
			H= y;
		}else{
			H= h-y;
		}
		
		System.out.println(Math.min(W, H));
	}
}