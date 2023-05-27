import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 완전탐색 재귀함수 중복가능 나열 응용문제
// 백준 14888

public class Main{
	static int N, answer; 
	static int[] A ,selected; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		answer =0;
		selected = new int[N+1];
		run(1);
		System.out.println(answer);

	}
	//						k는 행의 번호
	static void run(int k) throws IOException {
		if(k==N+1) {
			answer++;
			return;
		}

		else {
			loop1 :
			for(int i=1; i<=N;i++) {
//							선택된 열은 넘어간다
				if(selected[i] ==1) continue;
//							대각선에 해당하면 넘어가기
				for(int j=1;j<k;j++) {
					if(A[k-j]==i+j || A[k-j]==i-j ) continue loop1;
				}
				A[k]=i;
				selected[i]=1;
				run(k+1);
				selected[i]=0;
			}	
		}
	}
}
