class Solution {
    public int solution(int[][] sizes) {
        int max_w = 0;
        int max_y = 0;
        for(int i=0;i<sizes.length;i++){
            max_w = Math.max(max_w,Math.max(sizes[i][0],sizes[i][1]));
            max_y = Math.max(max_y,Math.min(sizes[i][0],sizes[i][1]));
        }
        int answer = max_w * max_y;
        return answer;
    }
} 