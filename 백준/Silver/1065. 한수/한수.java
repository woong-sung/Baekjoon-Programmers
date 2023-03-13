import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int cnt = 0;
		for(int i =1;i<=N;i++) {
			int a = i;
			List<Integer> A = new ArrayList<Integer>(); //주어진 숫자 i의 각 자리수를 담은 배열
			while(a!=0) {
				A.add(a%10);
				a=a/10;
			}
			if(i<100) {
				cnt++;
			}
			else {
				int diff =A.get(0)-A.get(1);
				boolean hansu = true;
				for(int c=0;c<A.size()-1;c++) {
					if(A.get(c)-A.get(c+1)!=diff) {
						hansu =false;
						break;
					}
				}
				if (hansu==true) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}


