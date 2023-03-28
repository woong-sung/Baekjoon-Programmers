class Solution {
    static int ans,cnt;
    public static int solution(String word) {
        find(word, new StringBuilder());
        return ans;
    }

    public static void find(String word,StringBuilder sb){
        if(sb.toString().equals(word)){
            ans = cnt;
            return;
        }
        if(sb.length()==5) return;

        Character[] arr = new Character[]{'A','E','I','O','U'};

        for(int i=0;i<5;i++){
            cnt++;
            sb.append(arr[i]);
            find(word, sb);
            sb.deleteCharAt(sb.length()-1);
            if (ans!=0) return;
        }
    }
}