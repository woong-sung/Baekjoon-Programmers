import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[]{1, 1, 1, 1, 1};
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int t = 0; t < 5; t++) {
            String[] room = places[t];
            boolean[][] visited = new boolean[5][5];
            //세로
            for (int y = 0; y < 5; y++) {
                // 가로
                for (int x = 0; x < 5; x++) {
                    if (room[y].charAt(x) == 'P') {
                        if (answer[t] == 0) break;
                        visited[y][x] = true;
                        for (int i = 0; i < 4; i++) {
                            int ny = y + dy[i];
                            int nx = x + dx[i];

                            if (!check(room, ny, nx, 0, visited)) {
                                answer[t] = 0;
                            }
                        }
                    }
                    if (answer[t] == 0) break;
                }
                if (answer[t] == 0) break;
            }
        }

        return answer;
    }


    public static boolean check(String[] room, int y, int x, int cnt, boolean[][] visited) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        if (cnt == 2) return true;
        else if (y < 0 || x < 0 || x >= 5 || y >= 5) return true;
        else if (room[y].charAt(x) == 'X') return true;
        visited[y][x] = true;

        if (room[y].charAt(x) == 'P') return false;
        else {
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (!check(room, ny, nx, cnt + 1, visited)) return false;
                visited[ny][nx] = false;
            }

        }
        return true;
    }
}