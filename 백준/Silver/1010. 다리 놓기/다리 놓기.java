import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			run(b, a);
		}

	}

	static void run(int a, int b) {
		BigInteger res = new BigInteger("1");

		for (int i = 0; i < b; i++) {
			BigInteger biga = new BigInteger(Integer.toString(a - i));
			res = res.multiply(biga);
		}
		for (int i = 0; i < b; i++) {
			BigInteger bigb = new BigInteger(Integer.toString(b - i));
			res = res.divide(bigb);
		}

		System.out.println(res);
	}
}