import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//정렬
//백준 1015
public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N;i++) {
			A[i]=B[i]= Integer.parseInt(st.nextToken());
		}

		Arrays.sort(B);
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(A[i] == B[j]) {
					P[i]=j;
					B[j]=null;
					break;
				}
			}
		}
		
		for(int i=0; i<N;i++) {
			System.out.print(P[i]+" ");
		}

	}
}