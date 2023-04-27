import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<skill.length();i++){
            map.put(skill.charAt(i),i);
        }
        for(int i=0;i<skill_trees.length;i++){
            boolean[] able = new boolean[skill.length()+1];
            boolean can = true;
            able[0] = true;
            String cur = skill_trees[i];
            for(int j=0;j<cur.length();j++){
                char c = cur.charAt(j);
                if(map.containsKey(c)){
                    if(!able[map.get(c)]) {
                        can = false;
                        break;
                    } else {
                        able[map.get(c)+1] = true;
                    }
                    
                }
            }
            if(can) answer++;
        }
        
        return answer;
    }
}