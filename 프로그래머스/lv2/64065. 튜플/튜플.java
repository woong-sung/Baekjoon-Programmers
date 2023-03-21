import java.util.*;

class Solution {
    public static int[] solution(String s) {
        int[] answer = {};
        s = s.substring(1, s.length() - 1);
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                n++; 
            }
        }
        List<Integer>[] lists = new List[n];
        answer = new int[n];
        StringTokenizer st = new StringTokenizer(s, "}qwe");
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            str = str.replace("{", "");
            str = str.replace(",", " ");
            String[] a = str.split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("")) continue;
                list.add(Integer.parseInt(a[i]));
            }
            lists[list.size()-1] = list;
        }
        for (int i = lists.length-1; i >0 ; i--) {
            for (int j = 0; j < lists[i-1].size(); j++) {
                lists[i].remove(lists[i - 1].get(j));
            }
        }
        for (int i = 0; i < lists.length; i++) {
            answer[i] = lists[i].get(0);
        }
        return answer;
    }
}