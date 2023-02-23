import java.util.*;

class Solution {
    // 정답가능한 애들 리스트
    public static ArrayList<int[]> list = new ArrayList<>();
    public static int max = -1;
    public static int[] lion, peach;

    public static int[] solution(int n, int[] info) {
        lion = new int[11];
        peach = info;

        dfs(n, 0, 0);
        if (max == -1) {
            return new int[]{-1};
        }
        Collections.sort(list, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 0;
        });

        return list.get(0);
    }

    public static void dfs(int n, int cur, int start) {
        if (cur == n) {
            int lionSum = 0;
            int peachSum = 0;
            for (int i = 0; i < 10; i++) {
                if (peach[i] == 0 && lion[i] == 0) {
                    continue;
                }
                if (peach[i] >= lion[i]) {
                    peachSum += 10 - i;
                } else {
                    lionSum += 10 - i;
                }
            }
            if (lionSum > peachSum) {
                int temp = lionSum - peachSum;
                if (temp > max) {
                    max = temp;
                    list.clear();
                    list.add(lion.clone());
                } else if (temp == max) {
                    list.add(lion.clone());
                }
            }
            return;
        }
        for (int i = start; i < 11; i++) {
            lion[i]++;
            dfs(n, cur + 1, i);
            lion[i]--;
        }
    }
}