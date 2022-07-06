import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		String num = br.readLine();
		int a = Integer.parseInt(num.split(" ")[0]);
		int b = Integer.parseInt(num.split(" ")[1]);
		
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		HashSet<Integer> tempA = new HashSet<>();
		
		String Aset = br.readLine();
		
		String Bset = br.readLine();
		
		StringTokenizer stA = new StringTokenizer(Aset," ");
		StringTokenizer stB = new StringTokenizer(Bset," ");
		
		for(int i=0;i<a;i++) {
			int c = Integer.parseInt(stA.nextToken());
			A.add(c);
			tempA.add(c);
		}
		for(int i=0;i<b;i++) {
			B.add(Integer.parseInt(stB.nextToken()));
		}
		tempA.removeAll(B);
		B.removeAll(A);
		int sum = tempA.size() +B.size();
		System.out.println(sum); 
	}
}