import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean[] visit = new boolean[words.length];
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            
            for(int j = 0;j<i;j++){
                String temp = words[j];
                if(temp.equals(cur)){
                    System.out.println(i+1);
                    answer[0] = (i+1)%n==0 ? n : (i+1)%n ;
                    answer[1] = i/n+1;
                    return answer;
                }
            }
            
            if(i!=words.length-1){
                String next = words[i+1];
                if(cur.charAt(cur.length()-1) != next.charAt(0)){
                    System.out.println(i+2);
                    answer[0] = (i+2)%n==0 ? n : (i+2)%n ;
                    answer[1] = (i+1)/n+1;
                    return answer;
                }
            }
        }
        return answer;
    }
}