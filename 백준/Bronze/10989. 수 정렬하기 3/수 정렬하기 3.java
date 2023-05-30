import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args)throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수

		int[] arr = new int[10001]; // 수의 최댓값+1
		 
		for (int i = 0; i < N; i++) { 
			arr[Integer.parseInt(br.readLine())]++;	
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			while(arr[i]-- > 0) {	// arr[i](작은수부터) 값이 0보타 클 경우 출력하고 -1개 
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}