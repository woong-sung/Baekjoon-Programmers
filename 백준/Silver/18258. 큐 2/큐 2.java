import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> program = new LinkedList<>();
        int last = -1;
        String input = "";
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            if (input.contains("push")) {
                program.add(last = Integer.parseInt(input.split(" ")[1]));
                continue;
            }
            switch (input) {
                case "pop":
                    if (program.peek() == null) sb.append(-1 + "\n");
                    else {
                        sb.append(program.poll() + "\n");
                        if (program.peek() == null) last = -1;
                    }
                    break;
                case "size":
                    sb.append(program.size() + "\n");
                    break;
                case "empty":
                    if (program.peek() == null) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "front":
                    if (program.peek() == null) sb.append(-1 + "\n");
                    else sb.append(program.peek() + "\n");
                    break;
                case "back":
                    sb.append(last + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
