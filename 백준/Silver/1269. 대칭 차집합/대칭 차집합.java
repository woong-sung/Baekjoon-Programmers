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
        HashSet<Integer> set = new HashSet<>();
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        for (int i=0;i<a;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2," ");
        for (int i=0;i<b;i++){
            set.add(Integer.parseInt(st2.nextToken()));
        }
        int answer = set.size() - (a + b - set.size());

        System.out.println(answer);
    }
}