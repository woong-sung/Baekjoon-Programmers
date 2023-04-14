import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dy = new int[]{0, 0, 1, -1};
        int[] dx = new int[]{1, -1, 0, 0};
        boolean[][][] visit = new boolean[maps.length][maps[0].length][4];
        int answer = -1;
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 1));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;
            int cCnt = cur.cnt;
            if (cy == maps.length - 1 && cx == maps[0].length - 1) {
                answer = cCnt;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= maps.length || ny < 0 || nx >= maps[0].length || nx < 0 || maps[ny][nx] == 0 || visit[ny][nx][i]) continue;
                visit[ny][nx][i] = true;
                q.add(new Node(ny, nx, cCnt + 1));
            }
        }
        return answer;
    }
}
class Node implements Comparable<Node> {
    int y;
    int x;
    int cnt;

    public Node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}