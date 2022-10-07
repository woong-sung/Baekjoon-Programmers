public class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            int[][] arr = new int[rows][columns];

            int c = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = c++;
                }
            }

            for (int i = 0; i < queries.length; i++) {
                int min = 10000;

                // todo : 배열을 회전시키면서 최솟값 갱신하기
                int y1 = queries[i][0] - 1;
                int x1 = queries[i][1] - 1;
                int y2 = queries[i][2] - 1;
                int x2 = queries[i][3] - 1;

                int total = ((x2 - x1 + 1) + (y2 - y1 + 1)) * 2 - 4;
                int cx = x1;
                int cy = y1;

                int temp = arr[y1 + 1][x1];

                int temp2 = 0;
                for (int j = 0; j < total; j++) {
                    temp2 = arr[cy][cx];
                    arr[cy][cx] = temp;
                    temp = temp2;
                    
                    if (cx < x2 && cy == y1) {
                        //오른쪽으로 이동
                        cx++;
                    } else if (cx == x2 && cy == y1) {
                        // 모서리 방향전환
                        cy++;
                    } else if (cx == x2 && cy < y2) {
                        //아래로 이동
                        cy++;
                    } else if (cx == x2 && cy == y2) {
                        // 모서리 방향전환
                        cx--;
                    } else if (cx > x1 && cy == y2) {
                        //왼쪽으로 이동
                        cx--;
                    } else if (cx == x1 && cy == y2) {
                        // 모서리 방향전환
                        cy--;
                    } else if (cx == x1 && cy < y2) {
                        //위로 이동
                        cy--;
                    }
                    min = Math.min(min, temp);
                }
                answer[i] = min;
            }
            return answer;
        }
    }