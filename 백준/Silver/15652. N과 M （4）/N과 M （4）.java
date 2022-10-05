import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	static int N,M; 
	static int[] selected ;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	//								k는 자릿수
	static void run(int k)throws IOException{
		if(k == M+1) {
			//			종료 : 한 줄에 M번 다 출력한경우 
			for(int i=1; i<=M; i++) {
				bw.write(selected[i]+" ");
			}
			bw.newLine();
			return;
			//			출력하고 줄바꿈
		}else {
			// 			start는 직전 자릿수의 숫자
			int start = selected[k-1];
			// 			맨처음은 0이므로 따로 설정
			if(start==0) start = 1;
			//			아닌경우 k 번째 자리는 j=start~N까지 입력
			//			다음자리 출력을 위해 k+1을 run에 입력
			for(int j=start; j<=N;j++) {
				selected[k] = j ;

				run( k+1);
			}
		}
	}
	public static void main(String[] args)throws IOException{ 
		// 완전탐색 재귀함수 중복가능 고르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		selected = new int[M+1];
		run(1);

		br.close();
		bw.flush();
		bw.close();

	}
}