import java.util.*;

public class Main {
    static int N,M,R;
    static int move;
    static int[] answer;
    static ArrayList<Integer> V;
    static ArrayList<Integer>[] E;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        answer = new int[N+1];
        // 정점 모음
        V = new ArrayList<>();
        // 해당 정점의 인접 정점 모음
        E = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            E[i] = new ArrayList<>();
        }
        // 간선정보 입력
        for (int i = 0; i <M ; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            E[u].add(v);
            E[v].add(u);
        }
        // 정점 번호를 내림차순으로 방문
        for (int i = 1; i <= N ; i++) {
            Collections.sort(E[i],Collections.reverseOrder());
        }
        // 방문했는지 확인하는 불리언배열
        visited = new boolean[N+1];



        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
    static void bfs(int start){

        Queue<Integer> q = new LinkedList<>();

        // 큐에 시작값을 넣는다.
        q.add(start);
        // 첫번째 입력하는 값은 무조건 들어가므로 트루입력 카운트도 1
        visited[start] = true;
        answer[start] = 1;
        // 이동횟수 처음이라 1
        move = 1;

        while(!q.isEmpty()){
            int temp = q.poll();
            //큐에서 뽑아와서 해당 정점에 연결된 모든 간선을 파악
            for (int i = 0; i < E[temp].size() ; i++) {
                int nextV = E[temp].get(i);

                if (visited[nextV]) continue;
                else {
                    q.add(nextV);
                    visited[nextV] = true;
                    answer[nextV] = ++move;
                }
            }
        }
    }
}