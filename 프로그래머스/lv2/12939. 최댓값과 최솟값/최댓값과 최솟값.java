import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int g = Integer.parseInt(arr[0]);
        int l = Integer.parseInt(arr[0]);
    
        for(int i=0;i<arr.length;i++){
            int curNum = Integer.parseInt(arr[i]);
            if(curNum >= l && curNum <= g) continue;
            if(curNum<l){
                l = curNum;                
            }
            if(curNum>g){
                g = curNum;
            }
        }
        answer = l + " " + g;

        return answer;
    }
}