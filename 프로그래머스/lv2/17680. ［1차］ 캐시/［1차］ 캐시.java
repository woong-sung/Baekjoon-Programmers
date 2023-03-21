import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        for(String city : cities){
            // 대소문자 구분을 하지 않는다.
            city = city.toUpperCase();
            if(list.contains(city)){
                list.remove(city);
                answer += 1;
            }else { 
                // list가 비어있는 경우 0번값을 삭제할 수 없으므로
                if(list.size()==cacheSize && !list.isEmpty()) {
                    list.remove(0);
                }
                answer += 5;
            }
            // 캐시사이즈가 0이 아니면 리스트에 시티 추가
            if(cacheSize!=0){
                list.add(city);    
            }
        }   
        return answer;
    }
}