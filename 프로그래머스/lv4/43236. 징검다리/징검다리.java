import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = distance;
        Arrays.sort(rocks);

        int min = 0;
        int max = distance;

        while (max >= min) {
            int mid = (max + min) / 2;
            int cnt = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }
            if (distance - rocks.length - 1 < mid) {
                cnt++;
            }
            if (cnt <= n) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
}