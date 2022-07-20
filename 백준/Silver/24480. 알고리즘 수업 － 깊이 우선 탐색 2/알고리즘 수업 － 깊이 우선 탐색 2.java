import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    static int N,M,R;
    static int move;
    static int[] answer;
    static ArrayList<Integer> node;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        answer = new int[N+1];
        node = new ArrayList<>();
        // 노드들의 리스트
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        // 간선정보 입력
        for (int i = 0; i <M ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }
        // 정점 번호를 내림차순으로 방문
        for (int i = 1; i <= N ; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }
        // 방문했는지 확인하는 불리언배열
        visited = new boolean[N+1];
        // 첫번째 입력하는 값은 무조건 들어가므로 트루입력 카운트도 1
        visited[R] = true;
        move = 1;
        // 재귀함수 실행
        run(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
    static void run(int t){
        // 정답경로에 +1씩 하면서 추가
        answer[t] = move++;
        for (int num : list[t]){
            // 방문한 경로면 넘어가기
            if (visited[num]==true) continue;
            // 아니면 방문체크하고 그 노드에 연결된 번호를 찾아서 run출발
            else {
                visited[num]= true;
                run(num);
            }
        }
    }
}