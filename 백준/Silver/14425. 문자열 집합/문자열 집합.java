import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);

		HashSet<String> S = new HashSet<>();
		for(int i=0; i<N; i++) {
			S.add(br.readLine());
		}

		String[] check =new String[M];
		for(int i=0; i<M; i++) {
			check[i] = br.readLine();
		}

		int cnt = 0 ;
		for(int i =0; i<M ;i++) {
				if(S.contains(check[i])) {
					cnt++;
				}
		}
		System.out.println(cnt);
	}
}
