class Solution {
        public int solution(String arr[]) {
            int max = 0;
            int min = 0;
            int sum = 0;
            int index = arr.length - 1;
//            for (int i = 0; i < arr.length-1 ; i ++) {
//                int num = Integer.parseInt(arr[arr.length - 1 - i]);
            while(index>=0){
                String s = arr[index];
                if (s.charAt(0)>='0'){
                    sum += Integer.parseInt(s);
                }
//                if (pm.equals("+")) sum += num;
//                else if (pm.equals("-")) {
                else if (s.equals("-")) {
                    int temp1 = -(sum + min);
                    int temp2 = -2*Integer.parseInt(arr[index+1]) + sum + max;
                    int temp3 = -(sum + max);
                    int temp4 = -sum + min;
                    max = Math.max(temp1, temp2);
                    min = Math.min(temp3, temp4);
                    sum = 0;
                }
                index--;
            }
            return max + sum;
        }
    }