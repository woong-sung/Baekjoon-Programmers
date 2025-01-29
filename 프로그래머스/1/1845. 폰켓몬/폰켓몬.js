function solution(nums) {
    var answer = 0;
    
    var set = new Set();
    for (var i = 0; i < nums.length ; i++){
        set.add(nums[i]);
    }
    answer = Math.min(set.size, nums.length / 2);
    return answer;
}