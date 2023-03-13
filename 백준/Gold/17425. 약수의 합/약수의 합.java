import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] fn = new long[1000000 + 1];
        long[] gn = new long[1000000 + 1];
        //100만까지 반복문을 돌며 겹치지 않는 가능한 배수의 조합을 찾는다.
        for (int i = 1; i <= 1000000; i++) {
            for (int j = i; j <= (1000000 / i); j++) {
                if (i == j) {
                    fn[i * j] += i;   //배수의 조합이 존재한다면 해당 숫자에 배수들을 더해준다(배수 == 약수)
                } else {
                    fn[i * j] += i + j;
                }
            }
        }

        //배수의 누적합을 계산
        for (int i = 1; i <= 1000000; i++) {
            gn[i] = gn[i - 1] + fn[i];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(gn[N] + "\n");
        }

        bw.flush();   //버퍼에 출력할 내용을 한번에 담아서 출력(시간 단축)
        bw.close();
    }
}
