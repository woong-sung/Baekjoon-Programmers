import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = (long)times[times.length - 1] * n;
        long min = 1;
        while (max >= min) {
            long mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if (sum >= n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return max + 1;
    }
}