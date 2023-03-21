class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(run(i)%2==0) answer += i;
            else answer-=i;
        }
        
        return answer;
    }
     
    static int run(int N){
        int cnt=0;
        for(int i=1;i<=N;i++){
            if(N%i==0) cnt++;
        }
        return cnt;
    }
}