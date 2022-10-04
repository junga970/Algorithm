import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        // key: 선수이름, value: 1로 추가, 동명이인이면 value + 1
        for (String s : participant) {
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else { hm.put(s, 1); }
        }

        // 해당하는 선수 value에 -1
        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }
        
        // value가 1이상이면 완주하지 못한 선수이므로 key리턴
        for (String key : hm.keySet()) {
            if (hm.get(key) > 0) {
                return key;
            }
        }

        return "";
    }
}
