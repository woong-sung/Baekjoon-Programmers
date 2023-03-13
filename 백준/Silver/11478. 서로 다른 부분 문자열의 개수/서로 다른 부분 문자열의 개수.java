import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String S = br.readLine();
		int n = S.length();
		
		HashSet<String> set = new HashSet<>();

		// i는 글자길이
		for (int i = 1; i <= n; i++) {
			//j는 시작위치
			for (int j = 0; j <n-i+1 ; j++) {
				set.add(S.substring(j,j+i));
			}
		}
		System.out.println(set.size());
	}
}