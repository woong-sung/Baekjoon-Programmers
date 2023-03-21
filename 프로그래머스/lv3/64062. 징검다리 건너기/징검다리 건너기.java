import java.util.*;
class Solution {
 public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
            int right = 200000000;

            while (left != right) {
                int mid = (left + right) / 2;
                if (can(mid, stones.clone(), k)) {
                    answer = Math.max(answer, mid);
                    left = mid +1 ;
                } else {
                    right = mid; 
                }
            }
            return answer;
        }

        public boolean can(int mid, int[] stones, int k) {
            int cnt = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid < 0) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if (cnt == k) {
                    return false;
                }
            }
            return true;
        }
    }