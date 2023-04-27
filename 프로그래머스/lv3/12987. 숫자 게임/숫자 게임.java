import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int idxA = A.length-1;
        int idxB = B.length-1;
        while(idxA>=0){
            if (A[idxA] < B[idxB]){
                idxB--;
                answer++;
            }
            idxA--;
        }
        return answer;
    }
}