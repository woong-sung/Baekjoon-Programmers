class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[m+1][n+1];

        for (int i = 0; i < puddles.length; i++) {
            int y = puddles[i][0];
            int x = puddles[i][1];
            arr[y][x] = -1;
        }
        arr[1][1] = 1;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (arr[i][j] == -1) continue;
                if (i-1>0 && arr[i - 1][j] != -1) arr[i][j] += arr[i - 1][j] % 1000000007;
                if (j-1>0 && arr[i][j - 1] != -1) arr[i][j] += arr[i][j - 1] % 1000000007;
            }
        }
        return arr[m][n] % 1000000007;
    }
}