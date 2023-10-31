class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (j==i) continue;
                for (int k = j; k < len; k++) {
                    if (k==j) continue;
                    if (number[i] + number[j] + number[k]==0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}