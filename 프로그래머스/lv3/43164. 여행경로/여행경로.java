import java.util.*;
class Solution {
    static List<String[]> ansLists;
    static boolean[] visit;
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        ansLists = new ArrayList<>();
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int ans = o1[0].compareTo(o2[0]);
                if (ans == 0 ) ans = o1[1].compareTo(o2[1]);
                return ans;
            }
        });

        List<String> route = new ArrayList<>();
        route.add("ICN");
        dfs(route, tickets.length,tickets);
        return ansLists.get(0);
    }

    public void dfs(List<String> route, int ticketSize, String[][] tickets){
        if (route.size()==ticketSize+1) {
            ansLists.add(route.toArray(new String[route.size()]));
            return;
        }

        String from = route.get(route.size() - 1);
        for (int i = 0; i < tickets.length; i++) {
            String ticketFrom = tickets[i][0];
            if (from.equals(ticketFrom) && !visit[i]) {
                visit[i] = true;
                String to = tickets[i][1];
                route.add(to);
                dfs(route,ticketSize,tickets);
                visit[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}