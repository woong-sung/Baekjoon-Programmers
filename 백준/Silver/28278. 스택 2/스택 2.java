import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        stack = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1 :
                    input(Integer.parseInt(st.nextToken()));
                    break;
                case 2 :
                    sb.append(pop());
                    sb.append("\n");
                    break;
                case 3 :
                    sb.append(count());
                    sb.append("\n");
                    break;
                case 4 :
                    sb.append(isEmpty());
                    sb.append("\n");
                    break;
                case 5 :
                    sb.append(pick());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    public static void input(int x){
        stack.add(x);
    }

    public static int pop(){
            return stack.size() == 0 ? -1 : stack.remove(stack.size() - 1);
    }

    public static int count(){
        return stack.size();
    }

    public static int isEmpty(){
        return stack.isEmpty() ? 1 : 0;
    }

    public static int pick(){
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
    }
}
