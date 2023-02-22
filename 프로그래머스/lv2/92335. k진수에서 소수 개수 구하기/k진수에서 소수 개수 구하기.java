import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String jinsu = Integer.toString(n, k);
        String[] parse = jinsu.split("0");
        StringTokenizer st = new StringTokenizer(jinsu, "0");
        while(st.hasMoreTokens()){
            long c = Long.parseLong(st.nextToken());
            if (check(c)&&c!=1){
                answer++;
            }
        }
        return answer;
    }

    public boolean check(long n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}