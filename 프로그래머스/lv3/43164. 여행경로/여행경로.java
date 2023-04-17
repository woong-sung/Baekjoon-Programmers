import java.util.*;
class Solution {
    static String[] answer;
    static boolean[] visit;
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];	// 중복 체크 배열
        answer = new String[tickets.length + 1];	// 정답 배열
        Arrays.sort(tickets, new Comparator<String[]>() {	// 티켓을 도착지기준으로 정렬
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        List<String> route = new ArrayList<>();	// 경로를 저장할 리스트
        route.add("ICN");	// 경로는 항상 ICN부터 시작
        dfs(route, tickets.length,tickets);
        return answer;
    }

    public void dfs(List<String> route, int ticketSize, String[][] tickets){
        if (route.size()==ticketSize+1) {	// 모든 티켓 사용
            answer = route.toArray(new String[route.size()]);
            return;
        }

        String last = route.get(route.size() - 1);	// 마지막 여행지
        for (int i = 0; i < tickets.length; i++) {
            String ticketFrom = tickets[i][0];
            if (last.equals(ticketFrom) && !visit[i]) {	// 마지막 여행지가 티켓의 출발지와 같다면
                visit[i] = true;
                String to = tickets[i][1];
                route.add(to);	// 도착지를 경로에 넣고 재귀반복
                dfs(route,ticketSize,tickets);
                if(answer[0]!=null) return;	// 정답을 이미 구한 경우 종료
                visit[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}