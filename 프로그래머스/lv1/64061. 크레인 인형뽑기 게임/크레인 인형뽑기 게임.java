import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        Queue<Integer>[] allBoard = new Queue[board.length];

        for (int i = 0; i < board.length; i++) {
            allBoard[i] = new LinkedList<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i]==0) continue;

                allBoard[i].add(board[j][i]);
            }
        }

        basket.add(allBoard[moves[0]-1].poll());
        for (int i = 1; i < moves.length; i++) {
            if (allBoard[moves[i] - 1].isEmpty()) {
                continue;
            }
            int cur = allBoard[moves[i]-1].poll();
            if (basket.isEmpty()) {
                basket.add(cur);
            } else {
                int basketTop = basket.peek();
                if (cur == basketTop) {
                    basket.pop();
                    answer+=2;
                } else {
                    basket.add(cur);
                }
            }
        }
        return answer;
    }
}