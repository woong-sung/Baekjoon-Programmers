import java.io.*;
import java.util.*;

public class Main {

    static int N,max,maxValueVertex;
    static Node[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adjList = new Node[N + 1];
        visited = new boolean[N + 1];
        maxValueVertex = 1;
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[start] = new Node(end, weight, adjList[start]);
            adjList[end] = new Node(start, weight, adjList[end]);
        }

        dfs(1, 0);  // 루트노드로부터 가장 멀리 있는 노드

        visited = new boolean[N + 1];

        dfs(maxValueVertex, 0); // 하나의 가장 멀리있는 점으로부터 다른 멀리있는 점 찾기
        System.out.println(max);
    }

    static void dfs(int vertex, int dist) { // 해당 정점으로부터 가장 멀리있는 점 찾기
        visited[vertex] = true;

        for (Node temp = adjList[vertex]; temp != null; temp = temp.link) {
            if (!visited[temp.vertex]) {
                dfs(temp.vertex, dist + temp.weight);
            }
        }

        if (max < dist) {
            max = dist;
            maxValueVertex = vertex;
        }
    }

    static class Node {
        int vertex;
        int weight;
        Node link;

        public Node(int vertex, int weight, Node link) {
            this.vertex = vertex;
            this.weight = weight;
            this.link = link;
        }
    }
}