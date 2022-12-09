class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int g = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int curNum = Integer.parseInt(arr[i]);
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