import java.util.*;

class Solution {
    public String solution(String s) {
               StringTokenizer st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());
        int minNum = list.get(0);
        int maxNum = list.get(list.size()-1);
        String answer = minNum + " " + maxNum;
        return answer;
    }
}