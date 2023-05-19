import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	static int N,M; 
	static int[] selected ,used ;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


//									k는 자릿수
	static void run(int k)throws IOException{
		if(k == M+1) {
//						종료 : 한 줄에 M번 다 출력한경우 
			for(int i=1; i<=M; i++) {
				bw.write(selected[i]+" ");
			}
			bw.newLine();
			return;
//						출력하고 줄바꿈
		}else {
//						아닌경우 k 번째 자리는 j=1~N까지 입력
//						다음자리 출력을 위해 k+1을 run에 입력
			for(int j=1; j<=N;j++) {
//						사용내역이 1이면 넘어가라
				if(used[j]==1) continue;
				selected[k] = j ;
				used[j] = 1;
				run( k+1);
//						k번째줄이 끝났으면 사용내역은 다음줄을위해 사용내역을0으로
				used[j] = 0;
			}
		}
	}
	public static void main(String[] args)throws IOException{ 
		// 완전탐색 재귀함수 중복불가능 순서있게나열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		selected = new int[M+1];
		used = new int[N+1];
		run(1);

		br.close();
		bw.flush();
		bw.close();

	}
}