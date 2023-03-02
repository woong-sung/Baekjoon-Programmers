import java.util.*;

class Solution {
    String[] users,bans;
    boolean[] userChecked;
    Set<String> banLists;
    int cnt;
    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        bans = banned_id;
        cnt = 0;
        banLists = new HashSet<>();
        for (int i = 0; i < users.length; i++) {
            userChecked = new boolean[user_id.length];
        }
        bfs(0,new ArrayList<>());
        return banLists.size();
    }

    public void bfs(int c,List<String> banlist) {
        if (c==bans.length) {
            Collections.sort(banlist);
            banLists.add(banlist.toString());
            return;
        }

        String ban = bans[c];
        for (int i = 0; i < users.length; i++) {
            if (!userChecked[i]) {
                if (checkId(users[i], ban)) {
                    userChecked[i] = true;
                    banlist.add(users[i]);
                    bfs(c+1,banlist);
                    banlist.remove(users[i]);
                    userChecked[i] = false;
                }
            }
        }
    }

    public boolean checkId(String user, String ban) {
        // 길이가 다르면 같지 않음
        if (user.length() != ban.length()) {
            return false;
        }
        // 가능성 있음
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i)=='*') continue;
            if (user.charAt(i) != ban.charAt(i)) {
                // 다름
                return false;
            }
        }
        //같음
        return true;
    }
}