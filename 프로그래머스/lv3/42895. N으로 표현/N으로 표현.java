import java.util.*;
    class Solution {
        static List<Node> list;
        static boolean[] visit;

        public int solution(int N, int number) {
            int answer = Integer.MAX_VALUE;
            visit = new boolean[100001];
            list = new ArrayList<>();
            String s = String.valueOf(N);
            int c = 1;
            while (Integer.parseInt(s) < 100000) {
                int f = Integer.parseInt(s);
                list.add(new Node(f,c++));
                visit[f] = true;
                s += N;
            }
            Queue<Node> q = new PriorityQueue<>();
            q.addAll(list);
            while(!q.isEmpty()){
                Node cur = q.poll();
                visit[cur.num] = true;
                if (cur.num == number) {
                    if (cur.cnt > 8) return -1;
                    return cur.cnt;
                }
                for (int i = 0; i < list.size(); i++) {
                    int idx = 0;
                    for (int j = 0; j < 6; j++) {
                        if (j==5 && cur.num==0) continue;
                        idx = cal(cur.num, list.get(i).num,j);
                        if (idx>= visit.length ) continue;
                        if (idx<0) continue;

                        if (!visit[idx]){
                            q.add(new Node(idx, cur.cnt + i+1));
                        }
                    }
                }
            }
            return 0;
        }

        private int cal(int num, int num1, int j) {
            if (j==0) return num + num1;
            if (j==1) return num - num1;
            if (j==2) return num * num1;
            if (j==3) return num / num1;
            if (j==4) return num1 - num;
            if (j==5) return num1 / num;
            return 0;
        }

        public static class Node implements Comparable<Node>{
            int num;
            int cnt;

            public Node(int num, int cnt) {
                this.num = num;
                this.cnt = cnt;
            }

            @Override
            public int compareTo(Node o) {
                return this.cnt-o.cnt;
            }
        }
    }