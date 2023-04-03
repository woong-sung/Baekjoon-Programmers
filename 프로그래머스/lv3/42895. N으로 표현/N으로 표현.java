import java.util.*;
class Solution {
    static List<Number> list;
    static boolean[] visit;

    public int solution(int N, int number) {
        int answer = Integer.MAX_VALUE;
        visit = new boolean[1000001];    // 중복체크
        list = new ArrayList<>();   // 해당숫자로 만들 수 있는 기본 숫자 리스트 {5,55,555,5555,...}
        // 리스트 채우기
        String s = String.valueOf(N);
        int c = 1;
        while (Integer.parseInt(s) < 1000000) {
            int f = Integer.parseInt(s);
            list.add(new Number(f,c++));
            visit[f] = true;
            s += N;
        }

        Queue<Number> q = new PriorityQueue<>();  //우선순위 큐로 설정하여 원하는 최솟값찾기
        q.addAll(list);
        // 큐에 계산 결과 넣으면서 원하는 값 찾기
        while(!q.isEmpty()){
            Number cur = q.poll();
            visit[cur.num] = true;
            if (cur.num == number) {
                if (cur.cnt > 8) return -1;
                return cur.cnt;
            }
            for (int i = 0; i < list.size(); i++) {
                int next = 0;
                for (int j = 0; j < 6; j++) {
                    if (j==5 && cur.num==0) continue;   // 0으로 나눌 수 없음
                    if (j==3 && list.get(i).num==0) continue;   // 0으로 나눌 수 없음
                    next = cal(cur.num, list.get(i).num,j); // 계산 결과
                    if (next>= visit.length || next<0 || visit[next]) continue; // 범위 밖 혹은 이미 방문

                    q.add(new Number(next, cur.cnt + i+1));
                }
            }
        }
        return 0;
    }

    private int cal(int num, int num1, int j) {     // 계산
        if (j==0) return num + num1;
        if (j==1) return num - num1;
        if (j==2) return num * num1;
        if (j==3) return num / num1;
        if (j==4) return num1 - num;
        if (j==5) return num1 / num;
        return 0;
    }

    public static class Number implements Comparable<Number>{   // 각 숫자와 만드는데 필요한 횟수를 저장
        int num;
        int cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) {
            return this.cnt-o.cnt;
        }
    }
}