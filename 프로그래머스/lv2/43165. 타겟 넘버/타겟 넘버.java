class Solution {
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    
    public static void dfs(int[] numbers, int target, int cur, int sum){
        if (cur == numbers.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        dfs(numbers, target, cur + 1, sum + numbers[cur]);
        dfs(numbers, target, cur + 1, sum - numbers[cur]);
    }
}