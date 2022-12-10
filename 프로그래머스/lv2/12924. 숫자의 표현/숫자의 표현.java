class Solution {
    public int solution(int n) {
        int front = 1;
        int back = 1;
        int sum = 0;
        int cnt = 0;
        // int[] arr = new int[n+1];
        while(front <= n){
            sum += front++;
            if(sum == n){
                cnt++;
            }
            while(sum >= n){
                sum -= back++;
                if(sum == n){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}