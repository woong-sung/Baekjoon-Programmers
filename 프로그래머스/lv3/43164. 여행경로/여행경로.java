import java.util.*;

class Solution {
    static Set<String> all;
    static List<String[]> ansLists;
    static Set<String> set;
    static boolean[] visit;
    public String[] solution(String[][] tickets) {
        all = new HashSet<>();
        set = new HashSet<>();
        visit = new boolean[tickets.length];
        ansLists = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            all.add(tickets[i][0]);
            all.add(tickets[i][1]);
        }
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int ans = o1[0].compareTo(o2[0]);
                if (ans == 0 ) ans = o1[1].compareTo(o2[1]);
                return ans;
            }
        });

        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs(list, tickets.length,tickets);
        return ansLists.get(0);
    }

    public void dfs(List<String> list, int c, String[][] tickets){
        if (list.size()==c+1) {
            ansLists.add(list.toArray(new String[list.size()]));
            return;
        }

        String from = list.get(list.size() - 1);
        for (int i = 0; i < tickets.length; i++) {
            String ticketFrom = tickets[i][0];
            if (from.equals(ticketFrom) && !visit[i]) {
                visit[i] = true;
                String to = tickets[i][1];
                list.add(to);
                dfs(list,c,tickets);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}