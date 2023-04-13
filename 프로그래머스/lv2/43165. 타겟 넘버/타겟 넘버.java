class Solution {
    static int cnt = 0;
    static int t;
    static int[] nums;
    
    public int solution(int[] numbers, int target) {
        t = target;
        nums = numbers;
        dfs(0,0);
        return cnt;
    }
    
    public static void dfs(int cur, int sum){
        if (cur == nums.length) {
            if (sum == t) {
                cnt++;
            }
            return;
        }
        dfs(cur + 1, sum + nums[cur]);
        dfs(cur + 1, sum - nums[cur]);
    }
}