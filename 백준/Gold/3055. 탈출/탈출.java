import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] dy = new int[]{0, 0, 1, -1};
        int[] dx = new int[]{1, -1, 0, 0};
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        ArrayList<Character[][]> water = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        Character[][] arr = new Character[R][C];
        int[][] waterTime = new int[R][C];
        int[][] moveTime = new int[R][C];

        int desY = 0;
        int desX = 0;

        for (int i = 0; i < R; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < C; j++) {
                waterTime[i][j] = 100000000;
                moveTime[i][j] = 100000000;

                char cur = str.charAt(j);
                arr[i][j] = cur;
                if (cur == '*') {
                    q.add(new Node(i, j));
                    waterTime[i][j] = 0;
                }
                if (cur == 'S') {
                    q2.add(new Node(i, j));
                    moveTime[i][j] = 0;
                }
                if (cur == 'D') {
                    desY = i;
                    desX = j;
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (arr[ny][nx] == 'X') continue;
                if (arr[ny][nx] == '.') {
                    if (waterTime[ny][nx] > waterTime[cur.y][cur.x] + 1) {
                        waterTime[ny][nx] = waterTime[cur.y][cur.x] + 1;
                        q.add(new Node(ny, nx));
                    }
                }
            }
        }

        while (!q2.isEmpty()) {
            Node cur = q2.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (arr[ny][nx] == 'X') continue;
                if (arr[ny][nx] == '.' && waterTime[ny][nx] > moveTime[cur.y][cur.x] + 1) {
                    if (moveTime[ny][nx] > moveTime[cur.y][cur.x] + 1) {
                        moveTime[ny][nx] = moveTime[cur.y][cur.x] + 1;
                        q2.add(new Node(ny, nx));
                    }
                }
                if (arr[ny][nx] == 'D' && waterTime[ny][nx] > moveTime[cur.y][cur.x] + 1) {
                    if (moveTime[ny][nx] > moveTime[cur.y][cur.x] + 1) {
                        moveTime[ny][nx] = moveTime[cur.y][cur.x] + 1;
                    }
                }
            }
        }
        int answer = moveTime[desY][desX];
        if (answer == 100000000) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
