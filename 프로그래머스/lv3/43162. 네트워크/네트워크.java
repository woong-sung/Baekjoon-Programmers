import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        List<Integer>[] list = new ArrayList[n];	// 각 컴퓨터에 연결된 컴퓨터번호를 저장할 배열
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }
        boolean[] checked = new boolean[n];	// 방문체크를 할 배열
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (checked[i]) continue;	// 이미 포함된 컴퓨터면 넘어가기
            q.add(i);
            cnt++;	// i번 컴퓨터를 시작으로 하는 새로운 네트워크가 생성
            while (!q.isEmpty()) {
                int cur = q.poll();	// 현재 컴퓨터
                checked[cur] =true;
                for (int next : list[cur]) {	// 현재 컴퓨터에 연결된 컴퓨터 모두 체크 
                    if (checked[next]) continue;
                    checked[next] = true;
                    q.add(next);
                }
            }
        }
        return cnt;
    }
}