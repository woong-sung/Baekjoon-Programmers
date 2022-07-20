import java.util.*;

public class Main {
    static int M, N;
    static boolean[] visited;
    static ArrayList<Integer>[] E;
    static ArrayList<Integer> V;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 컴퓨터의 수
        N = sc.nextInt();
        // 네트워크에 연결되어 있는 컴퓨터의 쌍의 수
        M = sc.nextInt();
        // 컴퓨터들의 모음(정점)
        V = new ArrayList<>();
        // 네트워크연결의 모음 (간선)
        E = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            E[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            E[x].add(y);
            E[y].add(x);
        }
        // 방문확인 하는 불리언
        visited = new boolean[N + 1];

        bfs(1);
        int cnt = 0;
        // 1번컴퓨터를 제외한 컴퓨터중 네트워크로 연결된 컴퓨터 찾기
        for (int i = 2; i < visited.length; i++) {
            if (visited[i] == true) cnt++;
        }
        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < E[temp].size(); i++) {
                int nextV = E[temp].get(i);
                if (visited[nextV] == true) continue;
                else {
                    q.add(nextV);
                    visited[nextV] = true;
                }
            }
        }
    }
}