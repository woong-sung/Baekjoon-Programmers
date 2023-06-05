import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {    // 스택의 길이가 폭발문보다 커야 체크
                boolean contains = true;

                for (int j = 0; j < bomb.length(); j++) {// 뒤에서부터 비교
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        contains = false;
                        break;
                    }
                }
                if (contains) { // 포함된 경우 폭발 시켜야하므로 제거
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
