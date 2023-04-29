import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, min, sum1, sum2;
	static int[] used, selected, teamS, teamL;
	//	static ArrayList<Integer> teamS, teamL;
	static int[][] S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		used = new int[N];
		for (int i = 0; i < N; i++) {
			used[i] = 0;
		}
		teamS = new int[N/2+1];
		teamL = new int[N/2+1];
		for(int i=0;i<=N/2;i++) {
			teamS[i]=0;
			teamL[i]=0;
		}
		min = 100 * N;

		run(1);

		System.out.println(min);
	}

	static void run(int k) {
		if (k == N / 2 +1) {
			sum1 = 0;
			sum2 = 0;
			int c = 0;
			for(int j=1;j<=N/2;j++) {
				for (int i = c; i < N; i++) {
					if (used[i]==0) {
						teamL[j]=i;
						c= i+1;
						break;
					}
				}
			}
			// 합을구하는 함수
			sum1 = sum(teamS);
			sum2 = sum(teamL);

			min = Math.min(Math.abs(sum1 - sum2), min);
			//
			return;
		}
		for (int i = teamS[k-1]; i < N; i++) {
			if (used[i] != 1) {
				teamS[k]=i;
				used[i] = 1;
				run(k + 1);
				used[i] = 0;
				teamS[k]=0;
			}
		}

	}

	static int sum(int[] A) {

		int ans = 0;
		for (int i = 1; i <= N / 2; i++) {
			for (int j = 1; j <= N / 2; j++) {
				if (i == j)
					continue;
				ans += S[A[i]][A[j]];
			}
		}
		return ans;
	}
}