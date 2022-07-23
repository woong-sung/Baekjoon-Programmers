import java.util.*;

public class Main {
    static int N, M, V, move;
    static int[] answer;
    static ArrayList<Integer>[] list_array;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        answer = new int[N + 1];
        visited = new boolean[N + 1];

        list_array = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list_array[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list_array[x].add(y);
            list_array[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list_array[i]);
        }
        move = 1;
        dfs(V);
        int point = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == i) {
                    System.out.print(j + " ");
                    break;
                }
            }
        }
        System.out.print("\n");
        answer = new int[N + 1];
        visited = new boolean[N + 1];
        move = 1;
        bfs(V);
        point = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == i) {
                    System.out.print(j + " ");
                    break;
                }
            }
        }
    }

    static void dfs(int start) {
        answer[start] = move++;
        visited[start] = true;
        for (int i = 0; i < list_array[start].size(); i++) {
            if (visited[list_array[start].get(i)] == true) continue;
            else {
                dfs(list_array[start].get(i));
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        answer[start] = move;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < list_array[temp].size(); i++) {
                int nextV = list_array[temp].get(i);

                if (visited[nextV] == true) continue;
                else {
                    q.add(nextV);
                    visited[nextV] = true;
                    answer[nextV] = ++move;
                }
            }
        }
    }
}