class Solution {
    public int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i=0;i<binaryN.length();i++){
            if(binaryN.charAt(i) == '1'){
                cnt ++;
            }
        }
        while (n<1000001){
            String binaryN2 = Integer.toBinaryString(++n);
            int cnt2 = 0;
            for(int i=0;i<binaryN2.length();i++){
                if(binaryN2.charAt(i) == '1'){
                    cnt2 ++;
                }
            }
            if(cnt==cnt2){
                break;
            }
        }
        return n;
    }
}