import java.util.*;
class Solution {
    Map<Long, Long> map;
    public long[] solution(long k, long[] room_number) {
         map = new HashMap<>();
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = run(room_number[i]);;
        }

        return answer;
    }

    public long run(long c) {
        if (!map.containsKey(c)) {
            map.put(c, c + 1);
            return c;
        } else {
            long next = run(map.get(c));
            map.put(c, next);
            return next;
        }
    }
}