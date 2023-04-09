class Solution {
    public int solution(String arr[]) {
        int max = 0;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < arr.length-1 ; i += 2) {
            int num = Integer.parseInt(arr[arr.length - 1 - i]);
            String pm = arr[arr.length - 2 - i];
            if (pm.equals("+")) sum += num;
            else if (pm.equals("-")) {
                int temp1 = -(num + sum + min);
                int temp2 = -num + sum + max;
                int temp3 = -(num+ sum + max);
                int temp4 = -(num + sum) + min;
                max = Math.max(temp1, temp2);
                min = Math.min(temp3, temp4);
                sum = 0;
            }
        }
        return max + Integer.parseInt(arr[0]) + sum;
    }
}