import java.util.Scanner;

public class Main{
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //가로
		int M = sc.nextInt(); //세로
		sc.nextLine();

		//보드판 생성
		char[][] che = new char[N][M];

		for(int i =0; i<N;i++) {
			String str = sc.nextLine();
			for(int j = 0;j<M;j++) {
				che[i][j] = str.charAt(j);
			}
		}
		if(N>8 || M>8) {
			int cnt=64;
			for(int i=0; i<N-7 ; i++) {
				for(int j=0; j<M-7 ; j++) {
					if(check(runMini(che,i , j))<cnt) {
						cnt = check(runMini(che,i , j));
					}
					
				}
			}
			System.out.println(cnt);
		}else {
			System.out.println(check(che));
		}
	}

	static char[][] runMini(char[][] A ,int n,int m){	//8x8 미니보드판 추출
		char[][] mini = new char[8][8];
		for(int i = 0 ;i<8 ;i++) {
			for(int j = 0 ;j<8 ;j++) {
				mini[i][j] = A[i+n][j+m];
			}
		}
		return mini ;
	}
	static int check(char[][] che) {	//틀린갯수 추출 프로그램
		int cnt = 64 ;
		//베스트 보드판-B시작
		char[][] best1 = new char[8][8];

		for(int i =0; i<8;i++) {

			for(int j = 0;j<8;j++) {
				if((i+j)%2==0) {
					best1[i][j] = 'B';
				}else {
					best1[i][j] = 'W';
				}
			}
		}

		//베스트 보드판-W시작
		char[][] best2 = new char[8][8];

		for(int i =0; i<8;i++) {

			for(int j = 0;j<8;j++) {
				if((i+j)%2==0) {
					best2[i][j] = 'W';
				}else {
					best2[i][j] = 'B';
				}
			}
		}

		//체크1
		int chk =0 ;
		for(int i =0; i<8;i++) {
			for(int j = 0;j<8;j++) {
				if(che[i][j]!=best1[i][j]) {
					chk++;
				}
			}
		}
		if(chk<cnt) {
			cnt = chk;
		}
		//체크2
		chk = 0;
		for(int i =0; i<8;i++) {
			for(int j = 0;j<8;j++) {
				if(che[i][j]!=best2[i][j]) {
					chk++;
				}
			}
		}
		if(chk<cnt) {
			cnt = chk;
		}
		return cnt;
	}
}