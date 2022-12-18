class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for(int j=0;j<10000;j++){
            int over = 0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=j){
                    over++;
                }
            }    
            if(over<j) return j-1;
        }
        
        return answer;
    }
}