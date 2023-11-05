class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] position = new int[27];
        
        for (int i =0; i<s.length();i++){
            char cur = s.charAt(i);
            int index = cur-'a';
            if (position[index] == 0) {
                answer[i] = -1;
            } else {    
                answer[i] = i + 1 - position[index];
            }
            System.out.println(answer[i]);
            position[index] = i+1;
        }
        return answer;
    }
}