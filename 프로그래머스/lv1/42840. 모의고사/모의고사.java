import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] first = new int[] {1,2,3,4,5};
        int[] second = new int[] {2,1,2,3,2,4,2,5};
        int[] third = new int[] {3,3,1,1,2,2,4,4,5,5};
        int[] sum = new int[3]; 
                
        for(int i=0;i<answers.length;i++ ){
            if(answers[i]==first[i%5]) sum[0]++;
            if(answers[i]==second[i%8]) sum[1]++;
            if(answers[i]==third[i%10]) sum[2]++;
        }
        
        int max = 0;
        int cnt = 0;
        for(int i=0;i<3;i++){
            if(max<sum[i]){
                max = sum[i];
                cnt = 1;
            }else if(max == sum[i]) cnt++;
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0;i<3;i++){
            if(sum[i]==max) {
                answer[idx++] = i+1;
            }
        }     
     
        return answer;
    }
}