import java.util.Stack;
class Solution {
        public String solution(String p) {
            if (check(p)) return p;
            else return dfs(p);
        }

        // 올바른 문자열인지 확인하는 메서드
        private static boolean check(String s) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    st.add(c);
                } else {
                    if (st.isEmpty()) return false;
                    st.pop();
                }
            }
            // 빈 문자열인 경우
            if (!st.isEmpty()) return false;
            else return true;
        }

        private static String dfs(String s) {
            // 조건1 : 빈문자열
            if (s.length() == 0) return s;
            // 조건2 : u,v 로 분리
            String u = "", v = "";
            int cnt1 = 0, cnt2 = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') cnt1++;
                else cnt2++;

                //균형잡힌 문자열일 때 u,v 분리
                if (((cnt1 > 0) && (cnt2 > 0)) && (cnt1 == cnt2)) {
                    u = s.substring(0, i + 1);
                    if (i < s.length() - 1) v = s.substring(i + 1, s.length());
                    break;
                }
            }

            // 조건3 : u가 올바른 괄호문자열인지 체크
            if (check(u)) {
                return u + dfs(v);
            } else {
                // 조건4 : u가 올바른 괄호문자열이 아니면
                String tmp = "(" + dfs(v) + ")";
                u = u.substring(1, u.length() - 1);
                u = u.replace("(", "p").replace(")", "(").replace("p", ")");
                tmp = tmp + u;
                return tmp;
            }
        }
    }