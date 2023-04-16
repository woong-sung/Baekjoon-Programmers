import java.util.*;
class Solution {
    static String[] answer;
    static boolean[] visit;
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        List<String> route = new ArrayList<>(); 
        route.add("ICN");
        dfs(route, tickets.length,tickets);
        return answer;
    }

    public void dfs(List<String> route, int ticketSize, String[][] tickets){
        if (route.size()==ticketSize+1) {
            answer = route.toArray(new String[route.size()]);
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
                if(answer[0]!=null) return;
                visit[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}