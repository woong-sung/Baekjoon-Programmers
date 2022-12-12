class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int length = 0;
        for(int i=1;i<=brown;i++){
            if(yellow%i==0){
                length = i+2;
                width = yellow/i+2;
                if((width+length)*2==brown+4){
                    break;
                }
            }
        }
        
        return new int[] {width, length};
    }
}