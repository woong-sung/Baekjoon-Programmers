class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cntZero = 0;
        int cnt = 0;
        while(!s.equals("1")){
            int len1 = s.length();
            s = s.replace("0","");    
            int len2 = s.length();
            cntZero += len1-len2;
            cnt++;
            s = Integer.toBinaryString(s.length());
        }
        
                   
        return new int []{cnt, cntZero};
    }
}