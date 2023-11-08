import java.util.*;

class Solution
{
public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (top == cur) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            } else {
                stack.push(cur);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}