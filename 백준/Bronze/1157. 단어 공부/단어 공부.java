import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String word = input.nextLine().toUpperCase();
		int cnt_max = 0;
		char result = 'A';

		for(int i=0;i<word.length();i++) {
			if ('A'== word.charAt(i)) {
				cnt_max++;
			}
		}
		
		for(char n ='B';n<='Z';n++) {
			int cnt = 0;
			for(int i=0;i<word.length();i++) {
				if (n== word.charAt(i)) {
					cnt++;
				}
			}
			if (cnt_max<cnt) {
				result = n;
				cnt_max=cnt;
			}
			else if(cnt_max==cnt) {
				result = '?';
			}
		}
		System.out.print(result);
	}
}

